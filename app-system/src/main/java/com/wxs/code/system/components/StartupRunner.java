package com.wxs.code.system.components;

import com.wxs.code.constant.RedisConstants;
import com.wxs.code.core.constant.SystemConstants;
import com.wxs.code.core.utils.RedisUtil;
import com.wxs.code.system.sysdict.service.IDictService;
import com.wxs.code.system.sysdictitem.entity.SysDictItem;
import org.dromara.hutool.core.bean.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class StartupRunner implements CommandLineRunner {


    @Autowired
    IDictService dictService;

    @Autowired
    JdbcTemplate jdbcTemplate;


    private List<SysDictItem> getCacheTables() {
        List tbs = RedisUtil.get(RedisConstants.CACHE_TABLES_KEY, List.class);
        if (tbs != null && !tbs.isEmpty()) {
            return tbs;
        }
        List<SysDictItem> sysDictItems = dictService.listDictItemByCode(SystemConstants.SYS_DICT.CACHE_TABLES);
        RedisUtil.set(RedisConstants.CACHE_TABLES_KEY, sysDictItems);
        return sysDictItems;
    }

    /**
     * 全表缓存
     */
    private void cacheTable(SysDictItem item) throws ClassNotFoundException {
        String table = item.getCode();
        Class clazz = item.getValue1() == null ? null : Class.forName(item.getValue1());

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from " + table);
        if (maps == null || maps.isEmpty()) {
            return;
        }
        for (Map map : maps) {
            Object object = BeanUtil.toBean(map, clazz);
            RedisUtil.set(item.getCode() + ":" + map.get("id"), object);
        }
    }


    @Override
    public void run(String... args) throws Exception {
        // 在这里编写应用启动后需要执行的任务
        System.out.println("应用启动后执行的任务");

        List<SysDictItem> cacheTables = getCacheTables();
        for (SysDictItem item : cacheTables) {
            System.out.println("缓存表：" + item.getCode());
            // 执行缓存表的初始化操作
            cacheTable(item);
        }
    }
}