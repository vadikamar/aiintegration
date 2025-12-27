package com.service.aiintegration.repositary;

import com.service.aiintegration.entity.Memory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryRepository extends MongoRepository<Memory, String> {
    // Custom query methods can be defined here if needed
}
