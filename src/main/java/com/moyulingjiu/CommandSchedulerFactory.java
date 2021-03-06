package com.moyulingjiu;

/**
 * 命令解析的工厂类
 *
 * @author 墨羽翎玖
 */
public class CommandSchedulerFactory {

    public static CommandScheduler start(Class<?> clazz) {
        return new CommandScheduler(clazz);
    }
}
