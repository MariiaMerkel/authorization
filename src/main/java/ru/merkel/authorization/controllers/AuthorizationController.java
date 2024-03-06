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
    public String checkLogin(@RequestParam(value = "login", required = false) String login, @RequestParam(value = "password", required = false) String password, @RequestParam(value = "confirmPassword", required = false) String confirmPassword) {
        try {
            if (login != null) {
                return authorization.checkLogin(login);
            }
            if (password != null && confirmPassword == null) {
                return authorization.checkPassword(password);
            }
            if (password != null && confirmPassword != null) {
                return authorization.checkConfirmPassword(password, confirmPassword);
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            return e.getMessage();
        }
        return "Что-то пошло не так";
    }
}
