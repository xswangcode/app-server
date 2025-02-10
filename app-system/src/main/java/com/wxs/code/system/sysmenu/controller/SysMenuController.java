/*
 *  @description: SysMenuController.java
 *
 *  @author:  xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update:
 *  @date:
 */

package com.wxs.code.system.sysmenu.controller;


import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.controller.CoreController;
import com.wxs.code.system.sysmenu.entity.SysMenu;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@OpenAPI30
@RestController
@RequestMapping("/system/sysmenu")
@Tag(name = "系统菜单表", description = "system模块-系统菜单表")
public class SysMenuController extends CoreController<SysMenu> {


    /**
     * 查询接口
     *
     * @param entity 实例参数化
     * @param req    http请求
     * @return
     */
    @GetMapping("list")
    @Operation(summary = "获取列表")
    @SaCheckPermission(value = "system:sys_menu:list")
    public RspMsg<List<SysMenu>> list(SysMenu entity, HttpServletRequest req) {
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
    @SaCheckPermission(value = "system:sys_menu:queryPageList")
    @Cacheable(value = "sys_menu", key = "#entity.toString()+':'+#pageNo+':'+#pageSize", unless = "#result.getResult().getTotal() <= 0")
    public RspMsg<IPage<SysMenu>> queryPageList(SysMenu entity,
                                                   @RequestParam(required = false, defaultValue = "1") Integer pageNo,
                                                   @RequestParam(required = false, defaultValue = "10") Integer pageSize,
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
    @SaCheckPermission(value = "system:sys_menu:queryById")
    public RspMsg<SysMenu> queryById(String id, HttpServletRequest req) {
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
    @SaCheckPermission(value = "system:sys_menu:deleteBatch")
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
    @SaCheckPermission(value = "system:sys_menu:delete")
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
    @SaCheckPermission(value = "system:sys_menu:edit")
    public RspMsg<String> edit(SysMenu entity, HttpServletRequest req) {
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
    @SaCheckPermission(value = "system:sys_menu:add")
    public RspMsg<String> add(SysMenu entity, HttpServletRequest req) {
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
    @SaCheckPermission(value = "system:sys_menu:addBatch")
    public RspMsg<String> addBatch(List<SysMenu> entity, HttpServletRequest req) {
        return super.addBatch(entity, req);
    }

}
