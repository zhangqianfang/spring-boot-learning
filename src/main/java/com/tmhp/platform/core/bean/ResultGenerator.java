package com.tmhp.platform.core.bean;

/***
 * 响应结果生成工具
 * @author zqf
 * @date 2018年5月3日
 */
public class ResultGenerator {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";

    public static Result genSuccessResult() {
        return new Result(ResultCode.SUCCESS.code(), DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result genSuccessResult(Object data) {
        return new Result(ResultCode.SUCCESS.code(), DEFAULT_SUCCESS_MESSAGE, data);
    }

    public static Result genSuccessResult(String message, Object data) {
        return new Result(ResultCode.SUCCESS.code(), message, data);
    }

    public static Result genFailResult() {
        return new Result(ResultCode.FAIL.code(), DEFAULT_FAIL_MESSAGE);
    }

    public static Result genFailResult(String message) {
        return new Result(ResultCode.FAIL.code(), message);
    }

    public static Result getResult(boolean success) {
        if (success) {
            return genSuccessResult();
        } else {
            return genFailResult();
        }
    }
}
