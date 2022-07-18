package com.moyulingjiu.scanner;

import com.moyulingjiu.cache.CommandCache;
import com.moyulingjiu.cache.FatherCommandCache;

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
        return new FatherCommandCache();
    }
}
