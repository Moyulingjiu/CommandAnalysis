package com.moyulingjiu.scanner;


import java.util.Set;
import java.util.function.Predicate;

/**
 * 扫描基类
 *
 * @author 墨羽翎玖
 */
public interface Scanner {
    String CLASS_SUFFIX = ".class";

    /**
     * 包扫描
     *
     * @param classPath 类名
     * @param packagePath 包名
     * @param predicate   约束规则
     * @return 类
     */
    Set<Class<?>> search(String classPath, String packagePath, Predicate<Class<?>> predicate);

    /**
     * 包扫描（无约束规则）
     *
     * @param classPath 类名
     * @param packagePath 包名
     * @return 类
     */
    default Set<Class<?>> search(String classPath, String packagePath) {
        return search(classPath, packagePath, null);
    }
}