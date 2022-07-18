package com.moyulingjiu.cache;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 对于单个命令有多个结果的
 *
 * @author 墨羽翎玖
 */
public class MultipleCommandCache extends CommandCache {
    private final List<CommandCache> commands = new ArrayList<>();

    public void add(CommandCache cache) {
        commands.add(cache);
    }

    @Override
    public void handle(Queue<String> message) {
        for (CommandCache cache : commands) {
            // 这里需要创建新的对象，避免message互相影响裁切
            cache.handle(new LinkedList<>(message));
        }
    }
}
