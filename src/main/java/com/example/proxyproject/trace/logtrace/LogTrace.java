package com.example.proxyproject.trace.logtrace;

import com.example.proxyproject.trace.TraceStatus;

/**
 * @author Lee Su Jeong
 * @date 2023/06/19
 */
public interface LogTrace {
    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus staus, Exception e);
}
