/*
 *  @description: Student.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/5/20 上午10:33
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.entity.biz;

import com.wxs.code.core.entity.CoreEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Getter
@Setter
@Schema(description = "学生实体类")
public class Student extends CoreEntity {
    @Schema(name = "id", description = "id")
    Integer id;
    @Schema(name = "name", description = "名称")
    String name;
    @Schema(name = "age", description = "年龄")
    Integer age;
    @Schema(name = "email", description = "邮箱")
    String email;
}
