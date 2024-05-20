package com.wxs.code.core.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.entity.BaseEntity;
import com.wxs.code.core.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

public abstract class BaseController<T extends BaseEntity> {

    @Autowired
    protected BaseService<T> baseService;

    //日志记录器
    protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);


    @GetMapping("list")
    @Operation(summary  = "获取列表")
    protected RspMsg<List<T>> list(@ModelAttribute T dto, HttpServletRequest req) {
        LambdaQueryWrapper<T> wrapper = Wrappers.lambdaQuery(dto);
        List<T> list = baseService.list(wrapper);
        return RspMsg.OK(list);
    }

    @GetMapping("pagelist")
    @Operation(summary  = "获取分页列表")
    protected RspMsg<IPage<T>> queryPageList(T dto,
                                          @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                          @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                          HttpServletRequest req) {
        LambdaQueryWrapper<T> wrapper = Wrappers.lambdaQuery(dto);
        IPage<T> page = new Page<>(pageNo, pageSize);
        page = baseService.page(page, wrapper);
        return RspMsg.OK(page);
    }

    @GetMapping("queryById")
    @Operation(operationId = "根据ID查询数据",summary  = "根据ID查询数据")
    protected RspMsg<T> queryPageList(@RequestParam(name = "id", required = true) String id,
                                   HttpServletRequest req) {

        T entity = baseService.getById(id);
        return RspMsg.OK(entity);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Operation(summary  = "批量删除")
    @DeleteMapping(value = "/deleteBatch")
    protected RspMsg<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        baseService.removeByIds(Arrays.asList(ids.split(",")));
        return RspMsg.OK("批量删除成功!");
    }

    @Operation(summary ="通过id删除")
    @DeleteMapping(value = "/delete")
    protected RspMsg<String> delete(@RequestParam(name="id",required=true) String id) {
        baseService.removeById(id);
        return RspMsg.OK("删除成功!");
    }

    @Operation(operationId = "单行编辑",summary ="单行编辑")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
    protected RspMsg<String> edit(@RequestBody T dto,
                               HttpServletRequest req) {
        baseService.updateById(dto);
        return RspMsg.OK("编辑成功!");
    }

    @Operation(summary ="单行新增")
    @RequestMapping(value = "/add", method = {RequestMethod.PUT,RequestMethod.POST})
    protected RspMsg<String> add(@RequestBody T dto,
                               HttpServletRequest req) {
        baseService.save(dto);
        return RspMsg.OK("新增成功!");
    }

    @Operation(summary ="批量新增")
    @RequestMapping(value = "/addBatch", method = {RequestMethod.PUT,RequestMethod.POST})
    protected RspMsg<String> addBatch(@RequestBody List<T> dto,
                              HttpServletRequest req) {
        baseService.saveBatch(dto);
        return RspMsg.OK("批量新增成功!");
    }


}
