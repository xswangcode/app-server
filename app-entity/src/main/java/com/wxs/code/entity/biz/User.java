package com.wxs.code.entity.biz;

import com.wxs.code.core.entity.CoreEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Getter
@Setter
@Schema(description = "用户类")
public class User extends CoreEntity {
    @Schema(name = "id", description = "id")
    Integer id;
    @Schema(name = "name", description = "名称")
    String name;
    @Schema(name = "age", description = "年龄")
    Integer age;
    @Schema(name = "email", description = "邮箱")
    String email;
}
