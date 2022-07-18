package com.moyulingjiu.scanner;

import com.moyulingjiu.cache.CommandCache;
import com.moyulingjiu.cache.FatherCommandCache;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 * 包扫描器
 *
 * @author 墨羽翎玖
 */
public class PackageScanner {

    /**
     * 扫描指定的包
     *
     * @param clazz 类
     * @return 命令缓存
     */
    public static CommandCache scanPackage(Class<?> clazz) {
        FatherCommandCache fatherCommandCache = new FatherCommandCache();

        URL resource = clazz.getResource("");
        assert resource != null;
        String classPath = resource.getPath().substring(1);
        String jarFilePath = clazz.getProtectionDomain().getCodeSource().getLocation().getFile();
        String packagePath = java.net.URLDecoder.decode(jarFilePath, StandardCharsets.UTF_8);
        if (!new File(classPath).exists()) {
            classPath = packagePath;
        }
        ScanExecutor instance = ScanExecutor.getInstance();
        Set<Class<?>> classes = instance.search(classPath, packagePath);

        // TODO: 转换为缓存格式
        return fatherCommandCache;
    }

    public static CommandCache scanPackage(String path) {
        FatherCommandCache fatherCommandCache = new FatherCommandCache();
        ScanExecutor instance = ScanExecutor.getInstance();
        Set<Class<?>> classes = instance.search(path, path);

        // TODO: 转换为缓存格式
        return fatherCommandCache;
    }
}
