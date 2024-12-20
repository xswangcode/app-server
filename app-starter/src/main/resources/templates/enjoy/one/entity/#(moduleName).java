/*
 *  @description: #(moduleName).java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午4:21
 *  @date: 2024-12-20 17:24
 *
 */

package #(packageName).#(entityPackage).#(moduleName.toLowerCase()).entity;

import com.alibaba.druid.sql.ast.statement.SQLIfStatement;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wxs.code.core.entity.BaseEntity;
import com.wxs.code.core.entity.CoreEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@ToString
@TableName("#(table)")
@Schema(description = "#(remark)")
@EqualsAndHashCode(callSuper = true)
public class #(moduleName) extends #(entityOption.isCoreEntity ? "CoreEntity" : "BaseEntity") {

#for (item : entityOption.fields)
    #if (item.field == "id")

        #if (item.type.indexOf("bigint") >= 0)
        @TableId(type = IdType.AUTO)
        @Schema(name = "id", description = "id")
        private Long id;

        #else if (item.type.indexOf("int") >= 0)
        @TableId(type = IdType.AUTO)
        @Schema(name = "id", description = "id")
        private Integer id;

        #else
        @TableId(type = IdType.ASSIGN_UUID)
        @Schema(name = "id", description = "id")
        private String id;

        #end
    #else
        @Schema(name = "#toSmallHumpName(item.field)", description = "#(item.comment)")
        #if (item.type.indexOf("bigint") >= 0)
        private Long #toSmallHumpName(item.field);

        #else if (item.type.indexOf("tinyint") >= 0)
        private Boolean #toSmallHumpName(item.field);

        #else if (item.type.indexOf("int") >= 0)
        private Integer #toSmallHumpName(item.field);

        #else if (item.type.indexOf("varchar") >= 0)
        private String #toSmallHumpName(item.field);

        #else if (item.type.indexOf("timestamp") >= 0 || item.type.indexOf("time") >= 0 || item.type.indexOf("datetime") >= 0)
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime #toSmallHumpName(item.field);

        #else if (item.type.indexOf("date") >= 0 )
        private LocalDate #toSmallHumpName(item.field);

        #else if (item.type.indexOf("text") >= 0 )
        private String #toSmallHumpName(item.field);

        #end
    #end
#end
}
