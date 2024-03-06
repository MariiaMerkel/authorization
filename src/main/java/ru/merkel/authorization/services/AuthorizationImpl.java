package ru.merkel.authorization.services;

import org.springframework.stereotype.Service;
import ru.merkel.authorization.excaptions.WrongLoginException;
import ru.merkel.authorization.excaptions.WrongPasswordException;

@Service
public class AuthorizationImpl implements Authorization {

    @Override
    public String checkLogin(String login) {
        if (login.length() <= 20) {
            if (login.matches("[a-zA-Z_]+")) {
                return "OK";
            } else {
                throw new WrongLoginException("Логин должен содержать только латинские буквы и символ подчёркивания");
            }
        } else {
            throw new WrongLoginException("Логин должен содержать не больше 20 символов");
        }
    }

    @Override
    public String checkPassword(String password) {
        if (password.length() <= 20) {
            if (password.matches("[\\w]+")) {
                return "OK";
            } else {
                throw new WrongPasswordException("Пароль должен содержать только цифры, латинские буквы и символ подчёркивания");
            }
        } else {
            throw new WrongPasswordException("Пароль должен содержать не больше 20 символов");
        }
    }

    @Override
    public String checkConfirmPassword(String password, String confirmPassword) {
        checkPassword(password);
        if (confirmPassword.equals(password)) {
            return "OK";
        } else {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}
