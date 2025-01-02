/*
 *  @description: SysRoleController.java
 *
 *  @author:  xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update:
 *  @date:
 */

package com.wxs.code.system.sysrole.controller;


import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.controller.CoreController;
import com.wxs.code.system.sysrole.entity.SysRole;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPI30
@RestController
@RequestMapping("/system/sysrole")
@Tag(name = "系统角色表", description = "system模块-系统角色表")
public class SysRoleController extends CoreController<SysRole> {


    /**
     * 查询接口
     *
     * @param entity 实例参数化
     * @param req    http请求
     * @return
     */
    @GetMapping("list")
    @Operation(summary = "获取列表")
    @SaCheckPermission(type = "system:sys_role:list")
    protected RspMsg<List<SysRole>> list(SysRole entity, HttpServletRequest req) {
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
    @SaCheckPermission(type = "system:sys_role:queryPageList")
    protected RspMsg<IPage<SysRole>> queryPageList(SysRole entity, Integer pageNo, Integer pageSize, HttpServletRequest req) {
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
    @SaCheckPermission(type = "system:sys_role:queryById")
    protected RspMsg<SysRole> queryById(String id, HttpServletRequest req) {
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
    @SaCheckPermission(type = "system:sys_role:deleteBatch")
    protected RspMsg<String> deleteBatch(String ids) {
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
    @SaCheckPermission(type = "system:sys_role:delete")
    protected RspMsg<String> delete(String id) {
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
    @SaCheckPermission(type = "system:sys_role:edit")
    protected RspMsg<String> edit(SysRole entity, HttpServletRequest req) {
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
    @SaCheckPermission(type = "system:sys_role:add")
    protected RspMsg<String> add(SysRole entity, HttpServletRequest req) {
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
    @SaCheckPermission(type = "system:sys_role:addBatch")
    protected RspMsg<String> addBatch(List<SysRole> entity, HttpServletRequest req) {
        return super.addBatch(entity, req);
    }

}
