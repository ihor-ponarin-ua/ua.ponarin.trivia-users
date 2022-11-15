package ua.ponarin.triviausers.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.ponarin.triviausers.dto.User;
import ua.ponarin.triviausers.mapper.UserMapper;
import ua.ponarin.triviausers.model.UserResponse;
import ua.ponarin.triviausers.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserResponse> findAll(
            @RequestParam(value = "login", required = false) String login,
            @RequestParam(value = "password", required = false) String password
    ) {
        return userService.findAll(Example.of(new User()
                .setLogin(login)
                .setPassword(password)
        )).stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable("id") Long id) {
        return userService.findById(id)
                .map(userMapper::toUserResponse)
                .orElseThrow(() -> new NoSuchElementException(String.format("User with id '%s' was not found", id)));
    }
}
