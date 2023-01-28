package com.hello.advenced.trace.template;

import com.hello.advenced.trace.TraceStatus;
import com.hello.advenced.trace.logtrace.LogTrace;

/**
 * 템플릿 메서드 패턴 - 다형성 이용
 * @param <T> - 제네릭을 사용 반환 타입 정의
 */
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
