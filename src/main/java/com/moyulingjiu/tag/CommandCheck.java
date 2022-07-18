package com.moyulingjiu.tag;

import com.moyulingjiu.checker.CommandChecker;
import com.moyulingjiu.checker.DefaultCommandChecker;

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
    Class<? extends CommandChecker> checker() default DefaultCommandChecker.class;
}
