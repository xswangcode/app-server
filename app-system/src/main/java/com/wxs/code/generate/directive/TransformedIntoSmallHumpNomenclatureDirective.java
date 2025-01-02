/*
 *  @description: TransformedIntoSmall.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/17 下午3:26
 *  @date: 2024-12-17 15:26
 *
 */

package com.wxs.code.generate.directive;


import com.jfinal.template.Directive;
import com.jfinal.template.Env;
import com.jfinal.template.io.Writer;
import com.jfinal.template.stat.Scope;
import com.wxs.code.generate.entity.DTO.DB.TableField;

/**
 * 将数据库字段转换为小驼峰命名法
 */
public class TransformedIntoSmallHumpNomenclatureDirective extends Directive {
    /**
     * 将数据库字段转换为小驼峰命名法
     */
    public static String transformToSmall(String fieldName) {
        String[] parts = fieldName.split("_");  // 根据下划线分割字符串
        StringBuilder camelCaseNameBuilder = new StringBuilder(); // 用来组合小驼峰字符串

        for (String part : parts) {
            if (camelCaseNameBuilder.length() == 0) {
                camelCaseNameBuilder.append(part.toLowerCase());  // 第一个单词保持小写
            } else {
                camelCaseNameBuilder.append(part.substring(0, 1).toUpperCase()) // 大写首字母
                        .append(part.substring(1).toLowerCase());  // 其他部分保持小写
            }
        }
        return camelCaseNameBuilder.toString();  // 返回小驼峰命名
    }

    @Override
    public void exec(Env env, Scope scope, Writer writer) {
        System.out.println(env);
        System.out.println(scope);
        scope.getData().forEach((k, v) -> {
            if (v instanceof TableField field) {
                write(writer, transformToSmall(field.getField()));
            }
        });
        System.out.println(writer);

    }
}
