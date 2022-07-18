package com.moyulingjiu.tag.valid;

import com.moyulingjiu.checker.ValueChecker;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对于字符串参数长度有效性检查
 *
 * @author 墨羽翎玖
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface StringValid {
    int min() default Integer.MIN_VALUE;

    int max() default Integer.MAX_VALUE;

    Class<? extends ValueChecker> checker() default ValueChecker.class;

    String message() default "长度超限";
}
