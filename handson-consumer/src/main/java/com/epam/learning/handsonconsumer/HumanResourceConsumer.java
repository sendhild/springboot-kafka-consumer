package com.epam.learning.handsonconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by savithasendhil on 3/11/19.
 */
@Service
public class HumanResourceConsumer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Logger logger = LoggerFactory.getLogger(HumanResourceConsumer.class);
    @KafkaListener(topics= "${app.topic}", groupId="group_id_1")
    public void consumeEmployeeHR(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message in HR System -> %s", message));
    }

}
