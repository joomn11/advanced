package com.hello.advenced.trace.threadlocal.code;

import com.hello.advenced.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {

    private String nameStore;

    public String logic(String name) {
        log.info("저장 name={}, nameStore={}",name, nameStore);
        this.nameStore = name;
        ThreadUtil.sleep(500);
        log.info("조회 nameStore={}", this.nameStore);
        return nameStore;
    }
}
