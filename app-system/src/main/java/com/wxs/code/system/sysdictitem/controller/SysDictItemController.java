/*
 *  @description: SysDictItemController.java
 *
 *  @author:  xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2025-02-14 15:59:26
 *  @date: 2025-02-14 15:59:26
 */

package com.wxs.code.system.sysdictitem.controller;


import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.controller.CoreController;
import com.wxs.code.system.sysdictitem.entity.SysDictItem;
import com.wxs.code.system.sysdictitem.mapper.SysDictItemMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPI30
@RestController
@RequestMapping("/system/sysdictitem")
@Tag(name = "数据字典子表", description = "system模块-数据字典子表")
public class SysDictItemController extends CoreController<SysDictItem, SysDictItemMapper> {


    /**
     * 查询接口
     *
     * @param entity 实例参数化
     * @param req    http请求
     * @return
     */
    @GetMapping("list")
    @Operation(summary = "获取列表")
    @SaCheckPermission(value = "system:sys_dict_item:list")
    public RspMsg<List<SysDictItem>> list(SysDictItem entity, HttpServletRequest req) {
        return super.list(entity, req);
    }

    /**
     * 分页查询
     *
     * @param entity   实例参数化
     * @param pageNo   当前页
     * @param pageSize 分页大小
     * @param req      http请求
     * @return
     */
    @GetMapping("pagelist")
    @Operation(summary = "获取分页列表")
    @SaCheckPermission(value = "system:sys_dict_item:queryPageList")
    public RspMsg<IPage<SysDictItem>> queryPageList(SysDictItem entity,
                                                   @RequestParam(required = false, defaultValue = "1") Integer pageNo,
                                                   @RequestParam(required = false, defaultValue = "10")  Integer pageSize,
                                                    HttpServletRequest req) {
        return super.queryPageList(entity, pageNo, pageSize, req);
    }

    /**
     * 根据ID查询数据
     *
     * @param id  实例id
     * @param req http请求
     * @return
     */
    @GetMapping("queryById")
    @Operation(operationId = "根据ID查询数据", summary = "根据ID查询数据")
    @SaCheckPermission(value = "system:sys_dict_item:queryById")
    public RspMsg<SysDictItem> queryById(String id, HttpServletRequest req) {
        return super.queryById(id, req);
    }

    /**
     * 批量删除
     *
     * @param ids 实例id集合
     *            eg: 1,2,3,4
     * @return
     */
    @Operation(summary = "批量删除")
    @DeleteMapping(value = "/deleteBatch")
    @SaCheckPermission(value = "system:sys_dict_item:deleteBatch")
    public RspMsg<String> deleteBatch(String ids) {
        return super.deleteBatch(ids);
    }

    /**
     * 删除数据
     *
     * @param id 实例id
     * @return
     */
    @Operation(summary = "通过id删除")
    @DeleteMapping(value = "/delete")
    @SaCheckPermission(value = "system:sys_dict_item:delete")
    public RspMsg<String> delete(String id) {
        return super.delete(id);
    }

    /**
     * 编辑数据
     *
     * @param entity 实例参数，需要传入id
     * @param req    http请求
     * @return
     */
    @Operation(operationId = "单行编辑", summary = "单行编辑")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    @SaCheckPermission(value = "system:sys_dict_item:edit")
    public RspMsg<String> edit(SysDictItem entity, HttpServletRequest req) {
        return super.edit(entity, req);
    }

    /**
     * 单行新增
     *
     * @param entity 实例参数
     * @param req    http请求
     * @return
     */
    @Operation(summary = "单行新增")
    @RequestMapping(value = "/add", method = {RequestMethod.PUT, RequestMethod.POST})
    @SaCheckPermission(value = "system:sys_dict_item:add")
    public RspMsg<String> add(SysDictItem entity, HttpServletRequest req) {
        return super.add(entity, req);
    }

    /**
     * 批量新增
     *
     * @param entity 实例参数集合
     * @param req
     * @return
     */
    @Operation(summary = "批量新增")
    @RequestMapping(value = "/addBatch", method = {RequestMethod.PUT, RequestMethod.POST})
    @SaCheckPermission(value = "system:sys_dict_item:addBatch")
    public RspMsg<String> addBatch(List<SysDictItem> entity, HttpServletRequest req) {
        return super.addBatch(entity, req);
    }

}
