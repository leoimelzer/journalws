package com.journal.journalws.repository;

import com.journal.journalws.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
