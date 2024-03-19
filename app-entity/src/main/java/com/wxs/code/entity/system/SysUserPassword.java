package com.wxs.code.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wxs.code.core.entity.CoreEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Getter
@Setter
@Schema(description = "用户密码类")
@TableName("sys_user_password")
@Builder
public class SysUserPassword extends CoreEntity {
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(name = "id", description = "id")
    Long id;

    Long sysUserId;

    @Schema(name = "password", description = "密码")
    String password;
}
