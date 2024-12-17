/*
 *  @description: #(moduleName)ServiceImpl.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/17 下午3:15
 *  @date: 2024-12-17 15:26
 *
 */

/*
 *  @description: #(moduleName)Service.java
 *
 *  @author:  #(author)
 *  @email: #(email)
 *  @version: #(version)
 *  @Test:  #date(time, "yyyy-MM-dd HH:mm:ss")
 *  @last update: #date(time, "yyyy-MM-dd HH:mm:ss")
 *  @date: #date(time, "yyyy-MM-dd HH:mm:ss")
 */


package #(packageName).#(entityPackage).#(moduleName.toLowerCase()).service;


import com.wxs.code.core.service.BaseService;
import org.springframework.stereotype.Service;
import #(packageName).#(entityPackage).#(moduleName.toLowerCase()).service.I#(moduleName)Service;
import #(packageName).#(entityPackage).#(moduleName.toLowerCase()).entity.#(moduleName);

@Service
public class #(moduleName)ServiceImpl extends BaseService<#(moduleName)> implements I#(moduleName)Service {

}
