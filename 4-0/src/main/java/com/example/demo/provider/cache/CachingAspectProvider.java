package com.example.demo.provider.cache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class CachingAspectProvider {

    private final MemoryCacheManager memoryCacheManager;

    //TODO: 클린 코드, 메서드 지저분함..
    @Around("@annotation(com.example.demo.provider.cache.Caching) && @annotation(target)")
    public Object handlerCaching(ProceedingJoinPoint joinPoint, Caching target) throws Throwable {

        //TODO: 파라미터를 key로 전달받을 방법이 있으면 좋을 듯
        var key = target.value() +
                (joinPoint.getArgs().length > 0 ? joinPoint.getArgs()[0] : "");

        return memoryCacheManager.get(key)
                .orElseGet(() -> {
                    try {
                        Object data = joinPoint.proceed();
                        memoryCacheManager.put(key, data);
                        return data;
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                        throw new RuntimeException("test...");
                    }
                });

    }
}