package com.feirasoft.kafkaservice.repository;

import com.feirasoft.kafkaservice.model.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<Log, String> {
}
