package ua.ponarin.triviausers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ua.ponarin.triviausers.dto.User;
import ua.ponarin.triviausers.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll(Example<User> userExample) {
        return userRepository.findAll(userExample);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
