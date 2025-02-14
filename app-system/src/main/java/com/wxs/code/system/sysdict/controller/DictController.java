/*
 *  @description: SysDictController.java
 *
 *  @author:  xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2025-02-14 15:58:29
 *  @date: 2025-02-14 15:58:29
 */

package com.wxs.code.system.sysdict.controller;


import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.controller.CoreController;
import com.wxs.code.system.sysdict.entity.SysDict;
import com.wxs.code.system.sysdict.service.IDictService;
import com.wxs.code.system.sysdictitem.entity.SysDictItem;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPI30
@RestController
@RequestMapping("/system/dict")
@Tag(name = "数据字典控制器", description = "system模块-数据字典")
public class DictController {

    @Autowired
    private IDictService dictSvc;

    /**
     * 查询主表参数为code的数据
     *
     * @param code
     * @return
     */
    @GetMapping("/listByCode")
    @Operation(summary = "查询主表编码为code的数据")
    public SysDict listDictByCode(String code) {
        return dictSvc.getDictByCode(code);
    }

    /**
     * 查询子表参数为dict_code = code的数据
     *
     * @param dict_code
     * @return
     */
    @GetMapping("/listItemByDictCode")
    @Operation(summary = "查询子表父编码为dict_code的数据")
    public List<SysDictItem> listItemByDictCode(String dict_code) {
        return dictSvc.listDictItemByCode(dict_code);
    }

    /**
     * 查询子表参数为pid的数据
     *
     * @param pid
     * @return
     */
    @GetMapping("/listItemByPid")
    @Operation(summary = "查询子表父id为pid的数据")
    public List<SysDictItem> listItemByPid(Long pid) {
        return dictSvc.listDictItemByPid(pid);
    }

    /**
     * 查询子表参数为pid = pid , code = code的数据
     *
     * @param pid
     * @param code
     * @return
     */
    @GetMapping("/getItemByPidCode")
    @Operation(summary = "查询子表父id为pid，且编码为code的数据")
    public SysDictItem getDictItemByCode(Long pid, String code) {
        return dictSvc.getDictItemByCode(pid, code);
    }

    /**
     * 查询子表参数为 dict_code = dict_code , code = code的数据
     *
     * @param dict_code
     * @param code
     * @return
     */
    @GetMapping("/getItemByDictcodeCode")
    @Operation(summary = "查询子表dict_code为dict_code，且编码为code的数据")
    public SysDictItem getDictItemByCode(String dict_code, String code) {
        return dictSvc.getDictItemByCode(dict_code, code);
    }

}
