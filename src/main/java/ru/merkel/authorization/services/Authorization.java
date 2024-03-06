package ru.merkel.authorization.services;

public interface Authorization {

    String checkLogin(String login);

    String checkPassword(String password);

    String checkConfirmPassword(String password, String confirmPassword);
}
