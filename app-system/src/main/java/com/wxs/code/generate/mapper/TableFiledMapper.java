/*
 *  @description: TableFiledMapper.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/17 上午10:57
 *  @date: 2024-12-17 15:26
 *
 */

package com.wxs.code.generate.mapper;


import com.wxs.code.generate.entity.DTO.DB.TableField;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TableFiledMapper {

    @Select("SHOW full COLUMNS FROM ${tableName};")
    List<TableField> getTableFiled(String tableName);
}
