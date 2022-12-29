package com.hello.advenced.trace.template;

import com.hello.advenced.trace.TraceStatus;
import com.hello.advenced.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String msg) {

        TraceStatus status = null;
        try {
            status = trace.begin(msg);

            // 로직 호출
            T result = call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }

    protected abstract T call();
}
