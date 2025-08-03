package com.journal.journalws.service;

import com.journal.journalws.dto.entry.EntryListRequest;
import com.journal.journalws.dto.entry.EntrySaveRequest;
import com.journal.journalws.model.Entry;
import com.journal.journalws.repository.EntryRepository;
import com.journal.journalws.repository.UserRepository;
import com.journal.journalws.util.common.RequestUtils;
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

    public Entry get(Long id) {
        return entryRepository.findById(id).orElse(null);
    }

    public List<Entry> list(EntryListRequest request) {
        return entryRepository
                .findAll()
                .stream()
                .filter(entry -> {
                    boolean matches = true;

                    if (request.getUserId() != null) {
                        matches &= request.getUserId().equals(entry.getUserId());
                    }

                    if (request.getPrivacy() != null) {
                        matches &= request.getPrivacy() != null && request.getPrivacy().equals(entry.getPrivacy());
                    }
                    return matches;
                })
                .toList();
    }

    public Long create(EntrySaveRequest request) {
        Entry entry = new Entry();
        String privacy = request.getPrivacy();

        entry.setCreatedAt(LocalDateTime.now());
        entry.setContent(request.getContent());
        entry.setTags(request.getTags());
        entry.setPrivacy(privacy);
        entry.setAllowedUsers(request.getAllowedUsers());

        Long userId = 1L; // TODO: Aqui tem que pegar do usuário dono do token da requisição
        entry.setUserId(userId);

        // TODO: Rever a lógica
//        entryRepository.findByUserId(userId).ifPresent(e -> {
//            System.out.println(e.getUserId());
//            e.setUserId(e.getUserId());
//        });

        Set<ConstraintViolation<Entry>> violations = validator.validate(entry);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        entryRepository.save(entry);
        return entry.getId();
    }

    public void update(Long id, EntrySaveRequest request) {
        Entry entry = get(id);

        String privacy = request.getPrivacy();
        entry.setContent(request.getContent());
        entry.setTags(request.getTags());
        entry.setPrivacy(privacy);

        List<String> allowedUsers = request.getAllowedUsers();
        entry.setAllowedUsers(allowedUsers);

        entry.setUpdatedAt(LocalDateTime.now());

        Set<ConstraintViolation<Entry>> violations = validator.validate(entry);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        entryRepository.save(entry);
    }

    public void delete(Long id) {
        Entry entry = get(id);
        entryRepository.delete(entry);
    }
}
