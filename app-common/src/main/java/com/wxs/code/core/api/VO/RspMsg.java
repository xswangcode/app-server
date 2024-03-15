package com.wxs.code.core.api.VO;

import com.wxs.code.core.constant.CommonConstants;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(name = "接口返回对象", description = "接口返回对象")
public class RspMsg<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    @Schema(name = "成功标志")
    private boolean success = true;

    /**
     * 返回处理消息
     */
    @Schema(name = "返回处理消息")
    private String message = "";

    /**
     * 返回代码
     */
    @Schema(name = "返回代码")
    private Integer code = 0;

    /**
     * 返回数据对象 data
     */
    @Schema(name = "返回数据对象")
    private T result;

    /**
     * 时间戳
     */
    @Schema(name = "时间戳")
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
        r.setRspMsg((T) msg);
        r.setMessage(msg);
        return r;
    }

    public static <T> RspMsg<T> ok(T data) {
        RspMsg<T> r = new RspMsg<T>();
        r.setSuccess(true);
        r.setCode(CommonConstants.HTTP_STATUS.OK);
        r.setRspMsg(data);
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
     * @return
     */
    public static <T> RspMsg<T> OK(String msg) {
        RspMsg<T> r = new RspMsg<T>();
        r.setSuccess(true);
        r.setCode(CommonConstants.HTTP_STATUS.OK);
        r.setMessage(msg);
        //RspMsg OK(String msg)方法会造成兼容性问题 issues/I4IP3D
        r.setRspMsg((T) msg);
        return r;
    }

    public static <T> RspMsg<T> OK(T data) {
        RspMsg<T> r = new RspMsg<T>();
        r.setSuccess(true);
        r.setCode(CommonConstants.HTTP_STATUS.OK);
        r.setRspMsg(data);
        return r;
    }

    public static <T> RspMsg<T> OK(String msg, T data) {
        RspMsg<T> r = new RspMsg<T>();
        r.setSuccess(true);
        r.setCode(CommonConstants.HTTP_STATUS.OK);
        r.setMessage(msg);
        r.setRspMsg(data);
        return r;
    }

    public static <T> RspMsg<T> error(String msg, T data) {
        RspMsg<T> r = new RspMsg<T>();
        r.setSuccess(false);
        r.setCode(CommonConstants.HTTP_STATUS.SERVER_ERROR);
        r.setMessage(msg);
        r.setRspMsg(data);
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


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setRspMsg(T result) {
        this.result = result;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
