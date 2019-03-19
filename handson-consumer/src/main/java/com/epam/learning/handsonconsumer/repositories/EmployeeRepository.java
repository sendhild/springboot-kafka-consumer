package com.epam.learning.handsonconsumer.repositories;

import com.epam.learning.handsonconsumer.model.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by savithasendhil on 3/8/19.
 */
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findBy_id(ObjectId _id);
}
