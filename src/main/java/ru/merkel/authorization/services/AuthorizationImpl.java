package ru.merkel.authorization.services;

import org.springframework.stereotype.Service;
import ru.merkel.authorization.excaptions.WrongLoginException;
import ru.merkel.authorization.excaptions.WrongPasswordException;

@Service
public class AuthorizationImpl implements Authorization {

    @Override
    public void checkLogin(String login) {
        if (login.length() > 20) {
            throw new WrongLoginException("Логин должен содержать не больше 20 символов");
        }
        if (!login.matches("[\\w]+")) {
            throw new WrongLoginException("Логин должен содержать только латинские буквы и символ подчёркивания");
        }
    }

    @Override
    public void checkPassword(String password) {
        if (password.length() > 20) {
            throw new WrongPasswordException("Пароль должен содержать не больше 20 символов");
        }
        if (!password.matches("[\\w]+")) {
            throw new WrongPasswordException("Пароль должен содержать только цифры, латинские буквы и символ подчёркивания");
        }
    }

    @Override
    public void checkConfirmPassword(String password, String confirmPassword) {
        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}
