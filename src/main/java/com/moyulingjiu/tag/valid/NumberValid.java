package com.moyulingjiu.tag.valid;

import com.moyulingjiu.checker.CommandChecker;
import com.moyulingjiu.checker.DefaultCommandChecker;
import com.moyulingjiu.checker.ValueChecker;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对于数字参数大小有效性检查
 *
 * @author 墨羽翎玖
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface NumberValid {
    long min() default Long.MIN_VALUE;

    long max() default Long.MAX_VALUE;

    Class<? extends ValueChecker> checker() default ValueChecker.class;

    String message() default "大小超限";
}
