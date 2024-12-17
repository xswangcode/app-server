/*
 *  @description: StudentMapper.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/17 下午3:26
 *  @date: 2024-12-17 15:26
 *
 */

package com.wxs.code.biz.student.mapper;

import com.wxs.code.biz.student.entity.Student;
import com.wxs.code.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
