package com.moyulingjiu.checker;

/**
 * 默认检查器
 *
 * @author 墨羽翎玖
 */
public class DefaultCommandChecker extends CommandChecker {
    public DefaultCommandChecker() {
    }

    @Override
    public boolean check() {
        return true;
    }
}
