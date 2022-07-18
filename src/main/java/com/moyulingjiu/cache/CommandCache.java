package com.moyulingjiu.cache;

import java.util.HashMap;
import java.util.Queue;

/**
 * 命令缓存，所有扫描过的注册的命令都会放到这里
 *
 * @author 墨羽翎玖
 */
public abstract class CommandCache {

    /**
     * 处理消息
     *
     * @param message 消息
     */
    public abstract void handle(Queue<String> message);
}
