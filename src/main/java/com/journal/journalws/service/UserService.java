package com.journal.journalws.service;

import com.journal.journalws.dto.user.UserSaveRequest;
import com.journal.journalws.model.User;
import com.journal.journalws.repository.UserRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    Validator validator;

    @Autowired
    private UserRepository userRepository;

    public User get(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public String create(UserSaveRequest request) {
        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        userRepository.save(user);

        return user.getId();
    }

    public void update(String id, UserSaveRequest request) {
        User user = get(id);

        if (user == null) {
            return;
        }

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        userRepository.save(user);
    }

    public void delete(String id) {
        User user = get(id);
        userRepository.delete(user);
    }
}
