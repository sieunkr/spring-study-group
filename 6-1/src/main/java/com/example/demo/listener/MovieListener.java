package com.example.demo.listener;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MovieListener {

    @RabbitListener(queues = "search.queue")
    public void receiveMessage(final CustomMessageDTO message) {

        log.info("listener message : {}", message);

        //TODO: 비즈니스 로직

    }
}
