package com.moyulingjiu.tag;

import com.moyulingjiu.checker.Checker;
import com.moyulingjiu.checker.DefaultChecker;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 执行之前的检查器
 *
 * @author 墨羽翎玖
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CommandCheck {
    Class<? extends Checker> checker() default DefaultChecker.class;
}
