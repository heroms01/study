package com.example.kafkademo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;

@Slf4j
@Component
public class UserProducer extends Producer {
    private final String TOPIC = "demo.topic";

    public void pubUser(User user) {
        publish(TOPIC, user);
    }

    public void pubUserList(List<User> userList) {
        publish(TOPIC, userList);
    }
}
