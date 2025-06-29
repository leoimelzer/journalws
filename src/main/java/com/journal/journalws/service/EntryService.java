package com.journal.journalws.service;

import com.journal.journalws.dto.EntryListRequest;
import com.journal.journalws.dto.EntrySaveRequest;
import com.journal.journalws.enums.EntryPrivacy;
import com.journal.journalws.model.Entry;
import com.journal.journalws.repository.EntryRepository;
import com.journal.journalws.repository.UserRepository;
import com.journal.journalws.util.RequestUtils;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class EntryService {

    @Autowired
    Validator validator;

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private UserRepository userRepository;

    public Entry get(String id) {
        return entryRepository.findById(id).orElse(null);
    }

    public List<Entry> list(EntryListRequest request) {
        return entryRepository
                .findAll()
                .stream()
                .filter(entry -> {
                    boolean matches = true;

                    if (request.getAuthorId() != null) {
                        matches &= request.getAuthorId().equals(entry.getAuthorId());
                    }

                    if (request.getPrivacy() != null) {
                        EntryPrivacy privacy = EntryPrivacy.getInstanceByValue(request.getPrivacy());
                        matches &= privacy != null && privacy.equals(entry.getPrivacy());
                    }
                    return matches;
                })
                .toList();
    }

    public String create(EntrySaveRequest request) {
        Entry entry = new Entry();

        entry.setCreatedAt(LocalDateTime.now());
        entry.setContent(request.getContent());
        entry.setTags(RequestUtils.getStringListByParameter(request.getTags()));
        entry.setTitle(request.getTitle());

        EntryPrivacy privacy = EntryPrivacy.getInstanceByValue(request.getPrivacy());
        if (privacy != null) {
            entry.setPrivacy(privacy);
        }

        String authorId = "author-id"; // TODO: Aqui tem que pegar do usuário dono do token da requisição
        userRepository.findUserById(authorId).ifPresent(user -> {
            System.out.println(user.getName());
            entry.setAuthorId(user.getId());
        });

        Set<ConstraintViolation<Entry>> violations = validator.validate(entry);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        entryRepository.save(entry);
        return entry.getId();
    }

    public void update(String id, EntrySaveRequest request) {
        Entry entry = get(id);

        entry.setTitle(request.getTitle());
        entry.setContent(request.getContent());
        entry.setTags(RequestUtils.getStringListByParameter(request.getTags()));

        EntryPrivacy privacy = EntryPrivacy.getInstanceByValue(request.getPrivacy());
        if (privacy != null) {
            entry.setPrivacy(privacy);
        }

        entry.setUpdatedAt(LocalDateTime.now());

        Set<ConstraintViolation<Entry>> violations = validator.validate(entry);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        entryRepository.save(entry);
    }

    public void delete(String id) {
        Entry entry = get(id);
        entryRepository.delete(entry);
    }
}
