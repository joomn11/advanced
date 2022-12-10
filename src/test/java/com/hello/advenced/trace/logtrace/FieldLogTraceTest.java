package com.hello.advenced.trace.logtrace;

import static org.junit.jupiter.api.Assertions.*;

import com.hello.advenced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class FieldLogTraceTest {

    LogTrace trace = new FieldLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus status1 = trace.begin("helloEx1");
        TraceStatus status2 = trace.begin("helloEx2");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }
}