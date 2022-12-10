package com.hello.advenced.trace.threadlocal;

import com.hello.advenced.trace.threadlocal.code.FieldService;
import com.hello.advenced.trace.threadlocal.code.ThreadLocalService;
import com.hello.advenced.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {

    private ThreadLocalService fieldService = new ThreadLocalService();

    @Test
    void fieldTest() {
        log.info("main start");
        Runnable runnableA = ()->{
            fieldService.logic("fieldA");
        };
        Runnable runnableB = ()->{
            fieldService.logic("fieldB");
        };
        Thread threadA = new Thread(runnableA);
        threadA.setName("thread-A");

        Thread threadB = new Thread(runnableB);
        threadB.setName("thread-B");

        threadA.start();
//        ThreadUtil.sleep(1000); // 동시성 문제 발생 X
        ThreadUtil.sleep(100); // 동시성 문제 발생 O

        threadB.start();

        ThreadUtil.sleep(1000); // main thread 종료 대기
        log.info("main end");
    }
}
