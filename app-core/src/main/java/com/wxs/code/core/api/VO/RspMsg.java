/*
 *  @description: RspMsg.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/3/19 上午10:57
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.core.api.VO;

import com.wxs.code.core.constant.CommonConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Schema(name = "接口返回对象", description = "接口返回对象")
@Data
@Getter
@Setter
public class RspMsg<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    @Schema(name = "success",description = "成功标志")
    private boolean success = true;

    /**
     * 返回处理消息
     */
    @Schema(name = "message",description = "返回处理消息")
    private String message = "";

    /**
     * 返回代码
     */
    @Schema(name = "code",description = "返回代码")
    private Integer code = 0;

    /**
     * 返回数据对象 data
     */
    @Schema(name = "result",description = "返回数据对象")
    private T result;

    /**
     * 时间戳
     */
    @Schema(name = "timestamp",description = "时间戳")
    private long timestamp = System.currentTimeMillis();

    public RspMsg() {
    }

    /**
     * 是否有错误
     * @return
     */
    public Boolean hasError(){
        return !success;
    }

    public RspMsg(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public RspMsg<T> success(String message) {
        this.message = message;
        this.code = CommonConstants.HTTP_STATUS.OK;
        this.success = true;
        return this;
    }

    public static <T> RspMsg<T> ok() {
        RspMsg<T> r = new RspMsg<T>();
        r.setSuccess(true);
        r.setCode(CommonConstants.HTTP_STATUS.OK);
        return r;
    }

    public static <T> RspMsg<T> ok(String msg) {
        RspMsg<T> r = new RspMsg<T>();
        r.setSuccess(true);
        r.setCode(CommonConstants.HTTP_STATUS.OK);
        r.setMessage(msg);
        return r;
    }

    public static <T> RspMsg<T> ok(T data) {
        RspMsg<T> r = new RspMsg<T>();
        r.setSuccess(true);
        r.setCode(CommonConstants.HTTP_STATUS.OK);
        r.setResult(data);
        return r;
    }

    public static <T> RspMsg<T> OK() {
        RspMsg<T> r = new RspMsg<T>();
        r.setSuccess(true);
        r.setCode(CommonConstants.HTTP_STATUS.OK);
        return r;
    }

    /**
     * 此方法是为了兼容升级所创建
     *
     * @param msg
     * @param <T>
     */
    public static <T> RspMsg<T> OK(String msg) {
        RspMsg<T> r = new RspMsg<T>();
        r.setSuccess(true);
        r.setCode(CommonConstants.HTTP_STATUS.OK);
        r.setMessage(msg);
        //RspMsg OK(String msg)方法会造成兼容性问题 issues/I4IP3D
        r.setResult((T) msg);
        return r;
    }

    public static <T> RspMsg<T> OK(T data) {
        RspMsg<T> r = new RspMsg<T>();
        r.setSuccess(true);
        r.setCode(CommonConstants.HTTP_STATUS.OK);
        r.setResult(data);
        return r;
    }

    public static <T> RspMsg<T> OK(String msg, T data) {
        RspMsg<T> r = new RspMsg<T>();
        r.setSuccess(true);
        r.setCode(CommonConstants.HTTP_STATUS.OK);
        r.setMessage(msg);
        r.setResult(data);
        return r;
    }

    public static <T> RspMsg<T> error(String msg, T data) {
        RspMsg<T> r = new RspMsg<T>();
        r.setSuccess(false);
        r.setCode(CommonConstants.HTTP_STATUS.SERVER_ERROR);
        r.setMessage(msg);
        r.setResult(data);
        return r;
    }

    public static <T> RspMsg<T> error(String msg) {
        return error(CommonConstants.HTTP_STATUS.SERVER_ERROR, msg);
    }

    public static <T> RspMsg<T> error(int code, String msg) {
        RspMsg<T> r = new RspMsg<T>();
        r.setCode(code);
        r.setMessage(msg);
        r.setSuccess(false);
        return r;
    }

    public RspMsg<T> error500(String message) {
        this.message = message;
        this.code = CommonConstants.HTTP_STATUS.SERVER_ERROR;
        this.success = false;
        return this;
    }


    public static <T> RspMsg<T> noauth(String msg) {
        return error(CommonConstants.HTTP_STATUS.UNAUTHORIZED, msg);
    }


}
