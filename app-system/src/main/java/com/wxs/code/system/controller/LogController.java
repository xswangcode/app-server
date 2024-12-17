/*
 *  @description: LogController.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/16 下午3:27
 *  @date: 2024-12-17 15:26
 *
 */

/*
 * *
 *  * ${description}
 *  *
 *  * @name: ${NAME}
 *  * @author: ${USER}
 *  * @date: $YEAR-${MONTH}-${DAY} ${HOUR}:${MINUTE}
 *  *
 */

/*
 * *
 *  * ${description}
 *  *
 *  * @name: ${NAME}
 *  * @author: ${USER}
 *  * @date: $YEAR-${MONTH}-${DAY} ${HOUR}:${MINUTE}
 *  *
 */

/*
 * *
 *  * ${description}
 *  *
 *  * @name: ${NAME}
 *  * @author: ${USER}
 *  * @date: $YEAR-${MONTH}-${DAY} ${HOUR}:${MINUTE}
 *  *
 */

package com.wxs.code.system.controller;

import com.wxs.code.core.controller.BaseController;
import com.wxs.code.system.entity.SysLog;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
@Tag(name = "日志", description = "系统模块-日志接口")
public class LogController extends BaseController<SysLog> {
}
