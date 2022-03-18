package com.example.demo.common.model;

import com.example.demo.common.exception.ErrorCode;
import org.slf4j.MDC;

/**
 * @auther suijinchi
 * @description
 * @date 2022/3/18
 */
public class ResultModel<T> extends Model {

    /**
     * @Fields serialVersionUID :
     */
    private static final long serialVersionUID = 1L;

    /**
     * 错误码：错误模块码(4位) | 错误级别码(2位) | 具体错误码(4位)
     */
    private long errCode;

    /**
     * 错误信息
     */
    private String errMsg;

    /**
     * 外部错误码：错误一级模块名(2位) | "-" | 错误二级模块码(2位) | 错误级别码(2位) | 具体错误码(4位)
     * 可选
     */
    private String code;

    private String requestId;

    private T data;

    public ResultModel() {
        this.requestId = MDC.get("traceId");
    }

    public ResultModel(T data) {
        this.requestId = MDC.get("traceId");
        this.setData(data);
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public long getErrCode() {
        return errCode;
    }

    public void setErrCode(long errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * adapte legacy code
     *
     * @param errCode
     */
    public void setResultCode(long errCode) {
        this.errCode = errCode;
    }

    /**
     * adapte legacy code
     *
     * @param errMsg
     */
    public void setResultMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public boolean isSuccess() {
        return ErrorCode.SUCCESS.getCode() == errCode;
    }

    public void setDetail(String detail) {
        this.errMsg += "::" + detail;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
