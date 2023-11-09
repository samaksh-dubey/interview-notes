package com.sam.ds.algo.practise;

public class HttpExecutor {
    public static <T> T process(HttpFunction<T> function, Class<T> T) {
        return function.call();
    }
}
