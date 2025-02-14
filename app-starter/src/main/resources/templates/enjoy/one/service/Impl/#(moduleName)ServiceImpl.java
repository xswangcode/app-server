/*
 *  @description: #(moduleName)ServiceImpl.java
 *
 *  @author:  #(author)
 *  @email: #(email)
 *  @version: #(version)
 *  @last update: #date(time, "yyyy-MM-dd HH:mm:ss")
 *  @date: #date(time, "yyyy-MM-dd HH:mm:ss")
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
