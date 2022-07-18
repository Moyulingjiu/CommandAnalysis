package com.moyulingjiu.tag;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指定包扫描路径
 * <p>
 * 该注解放在启动类上， CommandSchedulerFactory 在生成 CommandScheduler 的时候传入的class路径。
 * <p>
 * 默认只会扫描传入class的同名目录或者子目录，可以通过该注解强制指定需要扫描的目录。
 *
 * @author 墨羽翎玖
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CommandScan {
    String[] path();
}
