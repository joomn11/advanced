package com.hello.advenced.trace.threadlocal.code;

import com.hello.advenced.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {

    private ThreadLocal<String> nameStore = new ThreadLocal<>();

    public String logic(String name) {
        log.info("์ ์ฅ name={}, nameStore={}",name, nameStore.get());
        this.nameStore.set(name);
        ThreadUtil.sleep(500);
        log.info("์กฐํ nameStore={}", this.nameStore.get());
        return nameStore.get();
    }
}
