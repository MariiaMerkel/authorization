package ru.merkel.authorization.services;

public interface Authorization {

    void checkLogin(String login);

    void checkPassword(String password);

    void checkConfirmPassword(String password, String confirmPassword);
}
