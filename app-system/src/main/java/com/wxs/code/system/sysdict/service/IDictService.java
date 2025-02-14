package com.wxs.code.system.sysdict.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wxs.code.system.sysdict.entity.SysDict;
import com.wxs.code.system.sysdictitem.entity.SysDictItem;

import java.util.List;

public interface IDictService {

    /**
     * 查询主表参数为code的数据
     * @param code
     * @return
     */
    SysDict getDictByCode(String code);

    /**
     * 查询子表参数为dict_code = code的数据
     * @param dict_code
     * @return
     */
    List<SysDictItem> listDictItemByCode(String dict_code);

    /**
     * 查询子表参数为pid的数据
     * @param pid
     * @return
     */
    List<SysDictItem> listDictItemByPid(Long pid);


    /**
     * 查询子表参数为pid = pid , code = code的数据
     *
     * @param pid
     * @return
     */
    SysDictItem getDictItemByCode(Long pid,String code) ;

    /**
     * 查询子表参数为 dict_code = dict_code , code = code的数据
     *
     * @param dict_code
     * @return
     */
    SysDictItem getDictItemByCode(String dict_code,String code) ;

}
