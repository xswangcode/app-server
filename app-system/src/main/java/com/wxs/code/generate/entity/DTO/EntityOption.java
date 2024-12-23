/*
 *  @description: EntityOption.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/23 下午4:00
 *  @date: 2024-12-23 16:0
 *
 */

package com.wxs.code.generate.entity.DTO;


import com.wxs.code.generate.entity.DTO.DB.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Schema(name = "生成实体类的选项", description = "生成实体类的选项")
@Builder
public class EntityOption {
    @Schema(name = "fields", description = "表中的字段,不需要传参")
    List<TableField> fields;
    @Schema(name = "isCoreEntity", description = "是否生核心实体类，会有创建更新时间等字段")
    @Builder.Default
    Boolean isCoreEntity = false;
}
