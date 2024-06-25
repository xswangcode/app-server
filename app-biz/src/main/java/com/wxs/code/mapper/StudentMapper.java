/*
 *  @description: StudentMapper.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/3/16 上午10:44
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.mapper;

import com.wxs.code.core.mapper.BaseMapper;
import com.wxs.code.entity.biz.Student;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
