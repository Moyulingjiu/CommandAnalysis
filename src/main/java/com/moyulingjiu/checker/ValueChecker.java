package com.moyulingjiu.checker;

/**
 * 字段有效性检验
 * <p>
 * 子类可以继承该类去实现特殊的字段值校验，只要实现一个只有一个参数的check方法，并且与注解注释的字段同类型即可，将会自动注入。
 * <p>
 * 主要检查一些常见类型，例如：这个Integer字段只能为偶数
 *
 * @author 墨羽翎玖
 */
public class ValueChecker {
    public boolean check() {
        return true;
    }
}
