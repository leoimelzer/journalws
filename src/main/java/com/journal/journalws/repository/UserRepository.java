package com.journal.journalws.repository;

import com.journal.journalws.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findUserById(String id);
}
