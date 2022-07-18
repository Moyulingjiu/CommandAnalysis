package com.moyulingjiu.checker;

/**
 * 检查器（子类必须要有默认构造器）
 * <p>
 * 主要应用于某条命令执行之前是否需要进行某些检查。例如：频率限制、人员限制等。
 * <p>
 * 可以通过继承该类来实现自定义的检查手段。
 *
 * @author 墨羽翎玖
 */
public abstract class CommandChecker {
    public CommandChecker() {
    }

    /**
     * 是否检查通过
     * - true 通过
     * - false 不通过
     *
     * @return true/false
     */
    public abstract boolean check();
}
