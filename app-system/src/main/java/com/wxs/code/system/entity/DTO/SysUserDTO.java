package com.wxs.code.system.entity.DTO;

import com.wxs.code.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


@EqualsAndHashCode(callSuper = false)
@ToString
@Getter
@Setter
@Builder
@Schema(description = "用户注册-登录类")
public class SysUserDTO extends BaseEntity {

    @Schema(name = "name", description = "名称")
    String name;
    @Schema(name = "age", description = "年龄")
    Integer age;
    @Schema(name = "email", description = "邮箱")
    String email;

    /**
     * 明文密码
     */
    @Schema(name = "password", description = "密码")
    String password;

}
