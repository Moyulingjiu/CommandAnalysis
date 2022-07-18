package com.moyulingjiu.tag;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 命令注解
 * <p>
 * 用于标记某一个命令，并且给予一个唯一id，用于 CommandScheduler 对命令进行统一处理。
 *
 * @author 墨羽翎玖
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Command {
    /**
     * id 用于唯一标识一个命令
     */
    String id();

    /**
     * 命令，用于前置执行
     */
    String command();
}
