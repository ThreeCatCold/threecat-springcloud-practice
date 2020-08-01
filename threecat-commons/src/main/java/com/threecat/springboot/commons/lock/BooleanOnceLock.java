package com.threecat.springboot.commons.lock;

import java.util.concurrent.atomic.AtomicBoolean;

public class BooleanOnceLock {
    private static AtomicBoolean ATOMIC_BOOL = new AtomicBoolean(false);

    // 如果这里要支持无限获取锁的话，得用死循环，否抢锁失败就不执行了
    public static boolean getLock() {
        return ATOMIC_BOOL.compareAndSet(false, true);
    }

    public static void releaseLock() {
        ATOMIC_BOOL.set(false);
    }
}
