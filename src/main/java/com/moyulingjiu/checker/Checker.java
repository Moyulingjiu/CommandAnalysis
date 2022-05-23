package com.moyulingjiu.checker;

/**
 * 检查器（子类必须要有默认构造器）
 *
 * @author 墨羽翎玖
 */
public abstract class Checker {
    /**
     * 是否检查通过
     * - true 通过
     * - false 不通过
     *
     * @return true/false
     */
    public abstract boolean check();
}
