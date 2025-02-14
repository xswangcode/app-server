/*
 *  @description: ISysRoleService.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 上午10:39
 *  @date: 2024-12-20 17:24
 *
 */


package com.wxs.code.system.sysrole.service;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wxs.code.constant.RedisConstants;
import com.wxs.code.system.sysrole.entity.SysRole;
import org.springframework.cache.annotation.CacheEvict;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface ISysRoleService extends IService<SysRole> {

    List<SysRole> getByIds(List<Long> ids);

    /**
     * 批量修改插入
     *
     * @param entityList 实体对象集合
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default boolean saveOrUpdateBatch(Collection<SysRole> entityList) {
        return IService.super.saveOrUpdateBatch(entityList);
    }

    /**
     * 批量修改插入
     *
     * @param entityList 实体对象集合
     * @param batchSize  每次的数量
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    boolean saveOrUpdateBatch(Collection<SysRole> entityList, int batchSize);

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default boolean removeById(Serializable id) {
        return IService.super.removeById(id);
    }

    /**
     * 根据 ID 删除
     *
     * @param id      主键(类型必须与实体类型字段保持一致)
     * @param useFill 是否启用填充(为true的情况,会将入参转换实体进行delete删除)
     * @return 删除结果
     * @since 3.5.0
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default boolean removeById(Serializable id, boolean useFill) {
        return IService.super.removeById(id, useFill);
    }

    /**
     * 根据实体(ID)删除
     *
     * @param entity 实体
     * @since 3.4.4
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default boolean removeById(SysRole entity) {
        return IService.super.removeById(entity);
    }

    /**
     * 根据 columnMap 条件，删除记录
     *
     * @param columnMap 表字段 map 对象
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default boolean removeByMap(Map<String, Object> columnMap) {
        return IService.super.removeByMap(columnMap);
    }

    /**
     * 根据 entity 条件，删除记录
     *
     * @param queryWrapper 实体包装类 {@link QueryWrapper}
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default boolean remove(Wrapper<SysRole> queryWrapper) {
        return IService.super.remove(queryWrapper);
    }

    /**
     * 删除（根据ID 批量删除）
     *
     * @param list 主键ID或实体列表
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default boolean removeByIds(Collection<?> list) {
        return IService.super.removeByIds(list);
    }

    /**
     * 批量删除
     *
     * @param list    主键ID或实体列表
     * @param useFill 是否填充(为true的情况,会将入参转换实体进行delete删除)
     * @return 删除结果
     * @since 3.5.0
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default boolean removeByIds(Collection<?> list, boolean useFill) {
        return IService.super.removeByIds(list, useFill);
    }

    /**
     * 批量删除(jdbc批量提交)
     *
     * @param list 主键ID或实体列表(主键ID类型必须与实体类型字段保持一致)
     * @return 删除结果
     * @since 3.5.0
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default boolean removeBatchByIds(Collection<?> list) {
        return IService.super.removeBatchByIds(list);
    }

    /**
     * 批量删除(jdbc批量提交)
     *
     * @param list    主键ID或实体列表(主键ID类型必须与实体类型字段保持一致)
     * @param useFill 是否启用填充(为true的情况,会将入参转换实体进行delete删除)
     * @return 删除结果
     * @since 3.5.0
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default boolean removeBatchByIds(Collection<?> list, boolean useFill) {
        return IService.super.removeBatchByIds(list, useFill);
    }

    /**
     * 批量删除(jdbc批量提交)
     *
     * @param list      主键ID或实体列表
     * @param batchSize 批次大小
     * @return 删除结果
     * @since 3.5.0
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default boolean removeBatchByIds(Collection<?> list, int batchSize) {
        return IService.super.removeBatchByIds(list, batchSize);
    }

    /**
     * 批量删除(jdbc批量提交)
     *
     * @param list      主键ID或实体列表
     * @param batchSize 批次大小
     * @param useFill   是否启用填充(为true的情况,会将入参转换实体进行delete删除)
     * @return 删除结果
     * @since 3.5.0
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default boolean removeBatchByIds(Collection<?> list, int batchSize, boolean useFill) {
        return IService.super.removeBatchByIds(list, batchSize, useFill);
    }

    /**
     * 根据 ID 选择修改
     *
     * @param entity 实体对象
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default boolean updateById(SysRole entity) {
        return IService.super.updateById(entity);
    }

    /**
     * 根据 UpdateWrapper 条件，更新记录 需要设置sqlset
     *
     * @param updateWrapper 实体对象封装操作类 {@link UpdateWrapper}
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default boolean update(Wrapper<SysRole> updateWrapper) {
        return IService.super.update(updateWrapper);
    }

    /**
     * 根据 whereEntity 条件，更新记录
     *
     * @param entity        实体对象
     * @param updateWrapper 实体对象封装操作类 {@link UpdateWrapper}
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default boolean update(SysRole entity, Wrapper<SysRole> updateWrapper) {
        return IService.super.update(entity, updateWrapper);
    }

    /**
     * 根据ID 批量更新
     *
     * @param entityList 实体对象集合
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default boolean updateBatchById(Collection<SysRole> entityList) {
        return IService.super.updateBatchById(entityList);
    }

    /**
     * 根据ID 批量更新
     *
     * @param entityList 实体对象集合
     * @param batchSize  更新批次数量
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    boolean updateBatchById(Collection<SysRole> entityList, int batchSize);

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param entity 实体对象
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    boolean saveOrUpdate(SysRole entity);

    /**
     * 链式查询 lambda 式
     * kotlin 使用
     *
     * @return KtQueryWrapper 的包装类
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default KtUpdateChainWrapper<SysRole> ktUpdate() {
        return IService.super.ktUpdate();
    }

    /**
     * 链式更改 普通
     *
     * @return UpdateWrapper 的包装类
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default UpdateChainWrapper<SysRole> update() {
        return IService.super.update();
    }

    /**
     * 链式更改 lambda 式
     * <p>注意：不支持 Kotlin </p>
     *
     * @return LambdaUpdateWrapper 的包装类
     */
    @Override
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default LambdaUpdateChainWrapper<SysRole> lambdaUpdate() {
        return IService.super.lambdaUpdate();
    }

    /**
     * <p>
     * 根据updateWrapper尝试更新，否继续执行saveOrUpdate(T)方法
     * 此次修改主要是减少了此项业务代码的代码量（存在性验证之后的saveOrUpdate操作）
     * </p>
     * <p>
     * 该方法不推荐在多线程并发下使用，并发可能存在间隙锁的问题，可以采用先查询后判断是否更新或保存。
     * </p>
     * <p>
     * 该方法存在安全隐患将在后续大版本删除
     * </p>
     *
     * @param entity        实体对象
     * @param updateWrapper
     */
    @Override
    @Deprecated
    @CacheEvict(value = {RedisConstants.GET_PERMISSION_LIST_KEY, RedisConstants.GET_ROLE_LIST_KEY}, key = "#StpUtil.getLoginId() + ':' + #StpUtil.getLoginType()")
    default boolean saveOrUpdate(SysRole entity, Wrapper<SysRole> updateWrapper) {
        return IService.super.saveOrUpdate(entity, updateWrapper);
    }
}
