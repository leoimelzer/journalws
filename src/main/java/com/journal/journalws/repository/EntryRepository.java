package com.journal.journalws.repository;

import com.journal.journalws.model.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntryRepository extends MongoRepository<Entry, String> {
}
