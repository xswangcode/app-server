/*
 *  @description: #(moduleName)Mapper.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/17 下午3:15
 *  @date: 2024-12-17 15:26
 *
 */

package #(packageName).#(entityPackage).#(moduleName.toLowerCase()).mapper;

import com.wxs.code.core.mapper.BaseMapper;
import #(packageName).#(entityPackage).#(moduleName.toLowerCase()).entity.#(moduleName);
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface #(moduleName)Mapper extends BaseMapper<#(moduleName)> {

}
