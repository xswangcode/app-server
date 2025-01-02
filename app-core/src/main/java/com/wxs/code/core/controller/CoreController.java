/*
 *  @description: CoreController.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午5:24
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.core.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.entity.BaseEntity;
import com.wxs.code.core.service.BaseService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

public abstract class CoreController<T extends BaseEntity> extends BaseController {

    @Autowired
    protected BaseService<T> service;

    /**
     * 查询接口
     *
     * @param entity 实例参数化
     * @param req    http请求
     * @return
     */
    protected RspMsg<List<T>> list(@ModelAttribute T entity, HttpServletRequest req) {
        LambdaQueryWrapper<T> wrapper = Wrappers.lambdaQuery(entity);
        List<T> list = service.list(wrapper);
        return RspMsg.OK(list);
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

    protected RspMsg<IPage<T>> queryPageList(T entity,
                                             @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                             @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                             HttpServletRequest req) {
        LambdaQueryWrapper<T> wrapper = Wrappers.lambdaQuery(entity);
        IPage<T> page = new Page<>(pageNo, pageSize);
        page = service.page(page, wrapper);
        return RspMsg.OK(page);
    }

    /**
     * 根据ID查询数据
     *
     * @param id  实例id
     * @param req http请求
     * @return
     */

    protected RspMsg<T> queryById(@RequestParam(name = "id") String id, HttpServletRequest req) {

        T entity = service.getById(id);
        return RspMsg.OK(entity);
    }

    /**
     * 批量删除
     *
     * @param ids 实例id集合
     *            eg: 1,2,3,4
     * @return
     */
    protected RspMsg<String> deleteBatch(@RequestParam(name = "ids") String ids) {
        service.removeByIds(Arrays.asList(ids.split(",")));
        return RspMsg.OK("批量删除成功!");
    }

    /**
     * 删除数据
     *
     * @param id 实例id
     * @return
     */
    protected RspMsg<String> delete(@RequestParam(name = "id") String id) {
        service.removeById(id);
        return RspMsg.OK("删除成功!");
    }

    /**
     * 编辑数据
     *
     * @param entity 实例参数，需要传入id
     * @param req    http请求
     * @return
     */
    protected RspMsg<String> edit(@RequestBody T entity,
                                  HttpServletRequest req) {
        service.updateById(entity);
        return RspMsg.OK("编辑成功!");
    }

    /**
     * 单行新增
     *
     * @param entity 实例参数
     * @param req    http请求
     * @return
     */
    protected RspMsg<String> add(@RequestBody T entity,
                                 HttpServletRequest req) {
        service.save(entity);
        return RspMsg.OK("新增成功!");
    }

    /**
     * 批量新增
     *
     * @param entity 实例参数集合
     * @param req
     * @return
     */
    protected RspMsg<String> addBatch(@RequestBody List<T> entity,
                                      HttpServletRequest req) {
        service.saveBatch(entity);
        return RspMsg.OK("批量新增成功!");
    }

}
