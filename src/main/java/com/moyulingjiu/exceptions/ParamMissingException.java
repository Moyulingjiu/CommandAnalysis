package com.moyulingjiu.exceptions;

/**
 * 参数缺失异常
 *
 * @author 墨羽翎玖
 */
public class ParamMissingException extends RuntimeException {
    public ParamMissingException(String message) {
        super(message);
    }
}
