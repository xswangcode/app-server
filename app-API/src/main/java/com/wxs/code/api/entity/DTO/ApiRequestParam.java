/*
 *  @description: ApiRequestParam.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/3/16 下午12:28
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.api.entity.DTO;

import com.wxs.code.api.entity.OperationEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Schema(description = "Api接口请求参数")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class ApiRequestParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "接口地址")
    String api ;

    @Schema(description = "接口参数")
    Object data;

    @Schema(description = "签名")
    String sign;

    //  1:新增 2:修改 3:删除
    @Schema(description = "操作类型")
    OperationEnum operation;
}
