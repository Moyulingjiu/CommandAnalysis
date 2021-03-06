package com.moyulingjiu.tag;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 命令服务类注解
 * <p>
 * 有该注解注解的类，表示需要扫描该类的方法。如果类没有该注解，则会被跳过扫描，用于节省扫描的时间。
 *
 * @author 墨羽翎玖
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CommandService {
}
