package com.baeldung.service;

import com.baeldung.mockito.repository.User;
import com.baeldung.mockito.repository.UserRepository;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getById(@Nullable Integer id) {
        if (Objects.isNull(id)) {
            return Optional.empty();
        } else {
            Optional<User> optUser = userRepository.findById(id);
            if (optUser.isPresent() && Objects.nonNull(optUser.get().getStatus())) {
                return Optional.empty();
            } else {
                return optUser;
            }
        }
    }
}
