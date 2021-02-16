package com.example.demo.provider;

import com.example.demo.log.LogDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class LogProvider {

    private final KafkaTemplate<String, LogDTO> coffeeDTOKafkaTemplate;

    public void sendLogDTO(LogDTO log) {
        coffeeDTOKafkaTemplate.send("log-dto", log);
    }
}