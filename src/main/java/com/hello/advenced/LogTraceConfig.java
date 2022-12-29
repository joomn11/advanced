package com.hello.advenced;

import com.hello.advenced.trace.logtrace.FieldLogTrace;
import com.hello.advenced.trace.logtrace.LogTrace;
import com.hello.advenced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
//        return new FieldLogTrace();
        return new ThreadLocalLogTrace();
    }
}
