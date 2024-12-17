/*
 *  @description: Student.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/17 下午3:26
 *  @date: 2024-12-17 15:26
 *
 */

/*
 *  @description: Student.java
 *
 *  @author:  xswang
 *  @email: xswang.code@126.com
 *  @version: 1.0.0
 *  @last update: 2024-12-17 15:24:34
 *  @date: 2024-12-17 15:24:34
 */

package com.wxs.code.biz.student.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wxs.code.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@ToString
@TableName("student")
@Schema(description = "学生信息表")
@EqualsAndHashCode(callSuper = true)
public class Student extends BaseEntity {


    @TableId(type = IdType.AUTO)
    @Schema(name = "id", description = "id")
    private Integer id;

    @Schema(name = "name", description = "姓名")
    private String name;

    @Schema(name = "age", description = "年龄")
    private Integer age;

    @Schema(name = "email", description = "邮箱")
    private String email;

    @Schema(name = "userPassword", description = "明文密码")
    private String userPassword;

    @Schema(name = "createTime", description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @Schema(name = "ts", description = "创建时间2")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ts;

}
