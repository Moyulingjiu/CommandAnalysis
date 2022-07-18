package com.moyulingjiu.cache;

import java.util.HashMap;
import java.util.Queue;

/**
 * 父命令节点
 *
 * @author 墨羽翎玖
 */
public class FatherCommandCache extends CommandCache {
    private final HashMap<String, CommandCache> cacheHashMap = new HashMap<>();

    public CommandCache put(String key, CommandCache value) {
        return cacheHashMap.put(key, value);
    }

    public CommandCache get(String key) {
        return cacheHashMap.get(key);
    }

    public CommandCache getOrDefault(String key, CommandCache defaultValue) {
        return cacheHashMap.getOrDefault(key, defaultValue);
    }

    public CommandCache remove(String key) {
        return cacheHashMap.remove(key);
    }

    @Override
    public void handle(Queue<String> message) {
        String command = message.poll();
        CommandCache commandCache = cacheHashMap.getOrDefault(command, null);
        if (commandCache == null) {
            return;
        }
        commandCache.handle(message);
    }
}
