package com.moyulingjiu;

import com.moyulingjiu.cache.CommandCache;
import com.moyulingjiu.scanner.PackageScanner;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 命令调度器
 *
 * @author 墨羽翎玖
 */
public class CommandScheduler {
    private final CommandCache cache;

    public CommandScheduler(Class<?> clazz) {
        cache = PackageScanner.scanPackage(clazz);
    }

    public void handle(String message) {
        LinkedList<String> commands = new LinkedList<>(Arrays.asList(message.split(" ")));
        cache.handle(commands);
    }
}
