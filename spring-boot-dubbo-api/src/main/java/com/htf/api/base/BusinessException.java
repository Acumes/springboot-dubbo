package com.htf.api.base;

/**
 * 业务异常.
 *
 * @author zhangxd
 */
public class BusinessException extends Exception {

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

}