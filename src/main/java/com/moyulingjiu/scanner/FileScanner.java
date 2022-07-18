package com.moyulingjiu.scanner;

import com.moyulingjiu.exceptions.ScannerClassException;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * 对文件进行扫描
 *
 * @author 墨羽翎玖
 */
public class FileScanner implements Scanner {
    private static final String PACKAGE_SEPARATOR = ".";

    /**
     * 独立类，以应对并发搜索的情况
     */
    private static class ClassSearcher {
        private final Set<Class<?>> classPaths = new HashSet<>();

        /**
         * 递归扫描文件
         *
         * @param file        文件
         * @param packageName 包路径
         * @param predicate   约束规则
         * @param flag        标记（对于第一次不需要加点）
         * @return 类
         */
        private Set<Class<?>> searchPath(File file, String packageName, Predicate<Class<?>> predicate, boolean flag) {
            if (file.isDirectory()) {
                //文件夹我们就递归
                File[] files = file.listFiles();
                if (!flag) {
                    packageName = packageName + PACKAGE_SEPARATOR + file.getName();
                }
                if (files != null) {
                    for (File f1 : files) {
                        searchPath(f1, packageName, predicate, false);
                    }
                }
            } else {//标准文件
                //标准文件我们就判断是否是class文件
                if (file.getName().endsWith(CLASS_SUFFIX)) {
                    //如果是class文件我们就放入我们的集合中。
                    try {
                        Class<?> clazz = Class.forName(packageName + PACKAGE_SEPARATOR + file.getName().substring(0, file.getName().lastIndexOf(PACKAGE_SEPARATOR)));
                        if (predicate == null || predicate.test(clazz)) {
                            classPaths.add(clazz);
                        }
                    } catch (ClassNotFoundException e) {
                        throw new ScannerClassException(e.getMessage());
                    }
                }
            }
            return classPaths;
        }
    }

    @Override
    public Set<Class<?>> search(String classPath, String packagePath, Predicate<Class<?>> predicate) {
        String basePackPath = classPath.replace(PACKAGE_SEPARATOR, File.separator);
        String path = classPath.substring(packagePath.length() - 1).replace('/', '.');
        if (path.endsWith(PACKAGE_SEPARATOR)) {
            path = path.substring(0, path.length() - 1);
        }
        return new ClassSearcher().searchPath(new File(basePackPath), path, predicate, true);
    }
}
