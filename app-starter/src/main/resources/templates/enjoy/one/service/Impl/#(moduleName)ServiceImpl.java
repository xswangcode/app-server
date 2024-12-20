/*
 *  @description: #(moduleName)ServiceImpl.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 上午10:27
 *  @date: 2024-12-20 10:28
 *
 */


package #(packageName).#(entityPackage).#(moduleName.toLowerCase()).service.Impl;


import com.wxs.code.core.service.BaseService;
import org.springframework.stereotype.Service;
import #(packageName).#(entityPackage).#(moduleName.toLowerCase()).service.I#(moduleName)Service;
import #(packageName).#(entityPackage).#(moduleName.toLowerCase()).entity.#(moduleName);

@Service
public class #(moduleName)ServiceImpl extends BaseService<#(moduleName)> implements I#(moduleName)Service {

}
