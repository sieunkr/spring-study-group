package com.example.demo.provider.cache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class CachingAspectProvider {

    private final MemoryCacheManager memoryCacheManager;

    //TODO: 클린 코드
    @Around("@annotation(com.example.demo.provider.cache.MemoryCaching) && @annotation(target)")
    public Object handlerCaching(ProceedingJoinPoint joinPoint, MemoryCaching target) throws Throwable {

        if(StringUtils.isEmpty(target.value())) {
            return joinPoint.proceed();
        }

        //TODO: 클린코드 개선... 파라미터를 key로 전달하는 깔끔한 방법이 있는지 확인
        String cacheKey;
        if("NONE".equals(target.key())) {
            cacheKey = target.value();
        } else {
            CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
            var keyIndex = Arrays.asList(codeSignature.getParameterNames()).indexOf(target.key());
            cacheKey = target.value() + "::" +joinPoint.getArgs()[keyIndex];
        }

        return memoryCacheManager.get(cacheKey)
                .orElseGet(() -> {
                    try {
                        Object data = joinPoint.proceed();
                        memoryCacheManager.put(cacheKey, data);
                        return data;
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                        throw new RuntimeException("test...");
                    }
                });

    }
}