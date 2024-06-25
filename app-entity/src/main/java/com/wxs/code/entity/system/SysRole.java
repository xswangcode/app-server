/*
 *  @description: SysRole.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/6/25 上午9:48
 *  @date: 2024-6-25 10:51
 *
 */

package com.wxs.code.entity.system;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wxs.code.core.entity.CoreEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_role")
public class SysRole extends CoreEntity {
    @TableId
    Long id;

    String roleName;
    String roleCode;
}
