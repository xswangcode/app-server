package com.wxs.code.system.sysdict.service.Impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wxs.code.system.sysdict.entity.SysDict;
import com.wxs.code.system.sysdict.service.IDictService;
import com.wxs.code.system.sysdict.service.ISysDictService;
import com.wxs.code.system.sysdictitem.entity.SysDictItem;
import com.wxs.code.system.sysdictitem.service.ISysDictItemService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DictServiceImpl implements IDictService {
    private ISysDictService sysDictSvc;
    private ISysDictItemService sysDictItemSvc;

    public DictServiceImpl(ISysDictService sysDictSvc, ISysDictItemService sysDictItemSvc) {
        this.sysDictSvc = sysDictSvc;
        this.sysDictItemSvc = sysDictItemSvc;
    }


    /**
     * 查询主表参数为code的数据
     *
     * @param code
     * @return
     */
    @Override
    public SysDict getDictByCode(String code) {
        List<SysDict> data = sysDictSvc.list(Wrappers.lambdaQuery(SysDict.class).eq(SysDict::getCode, code));
        return data.size() > 0 ? data.get(0) : null;
    }

    /**
     * 查询子表参数为dict_code = code的数据
     *
     * @param dict_code
     * @return
     */
    @Override
    public List<SysDictItem> listDictItemByCode(String dict_code) {
        return sysDictItemSvc.list(Wrappers.lambdaQuery(SysDictItem.class).eq(SysDictItem::getDictCode, dict_code));
    }

    /**
     * 查询子表参数为pid的数据
     *
     * @param pid
     * @return
     */
    @Override
    public List<SysDictItem> listDictItemByPid(Long pid) {
        return sysDictItemSvc.list(Wrappers.lambdaQuery(SysDictItem.class).eq(SysDictItem::getPid, pid));
    }

    /**
     * 查询子表参数为pid = pid , code = code的数据
     *
     * @param pid
     * @param code
     * @return
     */
    @Override
    public SysDictItem getDictItemByCode(Long pid, String code) {
        List<SysDictItem> data = sysDictItemSvc.list(Wrappers.lambdaQuery(SysDictItem.class).eq(SysDictItem::getPid, pid).eq(SysDictItem::getCode, code));
        return data.size() > 0 ? data.get(0) : null;
    }

    /**
     * 查询子表参数为 dict_code = dict_code , code = code的数据
     *
     * @param dict_code
     * @param code
     * @return
     */
    @Override
    public SysDictItem getDictItemByCode(String dict_code, String code) {
        List<SysDictItem> data = sysDictItemSvc.list(Wrappers.lambdaQuery(SysDictItem.class).eq(SysDictItem::getDictCode, dict_code).eq(SysDictItem::getCode, code));
        return data.size() > 0 ? data.get(0) : null;
    }
}
