package com.moyulingjiu.scanner;

import java.util.Set;
import java.util.function.Predicate;

/**
 * 扫描接口
 *
 * @author 墨羽翎玖
 */
public class ScanExecutor implements Scanner {
    private volatile static ScanExecutor instance;

    @Override
    public Set<Class<?>> search(String classPath, String packagePath, Predicate<Class<?>> predicate) {
        Scanner fileSc = new FileScanner();
        Set<Class<?>> fileSearch = fileSc.search(classPath, packagePath, predicate);
        Scanner jarScanner = new JarScanner();
        Set<Class<?>> jarSearch = jarScanner.search(classPath, packagePath, predicate);
        fileSearch.addAll(jarSearch);
        return fileSearch;
    }

    private ScanExecutor() {
    }

    /**
     * 单例减小内存消耗
     *
     * @return ScanExecutor
     */
    public static ScanExecutor getInstance() {
        if (instance == null) {
            synchronized (ScanExecutor.class) {
                if (instance == null) {
                    instance = new ScanExecutor();
                }
            }
        }
        return instance;
    }

}
