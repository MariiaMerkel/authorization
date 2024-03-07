package ru.merkel.authorization.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.merkel.authorization.excaptions.WrongLoginException;
import ru.merkel.authorization.excaptions.WrongPasswordException;
import ru.merkel.authorization.services.Authorization;

@RestController
public class AuthorizationController {
    private final Authorization authorization;

    public AuthorizationController(Authorization authorization) {
        this.authorization = authorization;
    }

    @GetMapping()
    public String checkLogin(@RequestParam(value = "login") String login, @RequestParam(value = "password") String password, @RequestParam(value = "confirmPassword") String confirmPassword) {
        try {
                authorization.checkLogin(login);
                authorization.checkPassword(password);
                authorization.checkConfirmPassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            return e.getMessage();
        }
        return "OK";
    }
}
