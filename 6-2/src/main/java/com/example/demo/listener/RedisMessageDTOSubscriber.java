package com.example.demo.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class RedisMessageDTOSubscriber implements MessageListener {

    private ObjectMapper mapper = new ObjectMapper();

    public void onMessage(Message message, byte[] pattern) {

        try {

            CustomMessageDTO coffee = mapper.readValue(message.getBody(), CustomMessageDTO.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
