package com.me.example.demo.Infrastructure.utils.api;

/**
 * 生成id类
 * @Author: Chen Wei
 * @Date: Created in 10:33 2019/8/21
 */

public class IdWork {
    private static final SnowFlake snowFlake;

    static {
        snowFlake = new SnowFlake(1L, 1L);
    }

    public static String getId() {
        return String.valueOf(snowFlake.nextId());
    }
}
