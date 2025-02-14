/*
 *  @description: #(moduleName)Mapper.java
 *
 *  @author:  #(author)
 *  @email: #(email)
 *  @version: #(version)
 *  @last update: #date(time, "yyyy-MM-dd HH:mm:ss")
 *  @date: #date(time, "yyyy-MM-dd HH:mm:ss")
 *
 */

package #(packageName).#(entityPackage).#(moduleName.toLowerCase()).mapper;

import com.wxs.code.core.mapper.BaseMapper;
import #(packageName).#(entityPackage).#(moduleName.toLowerCase()).entity.#(moduleName);
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface #(moduleName)Mapper extends BaseMapper<#(moduleName)> {

}
