package com.epam.learning.handsonconsumer;

import com.epam.learning.handsonconsumer.model.Employee;
import com.epam.learning.handsonconsumer.repositories.EmployeeRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by savithasendhil on 3/11/19.
 */
@Service
public class EmployeeConsumer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private EmployeeRepository repository;

    private Logger logger = LoggerFactory.getLogger(EmployeeConsumer.class);

    @KafkaListener(topics = "${app.topic}", groupId = "group_id")
    public void consumeEmployee(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
        Employee emp = repository.findBy_id(new ObjectId(message));
        emp.setDepartment("IT Operations");
        emp.setLastModified(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss Z").format(new Date()));
        repository.save(emp);
    }
}
