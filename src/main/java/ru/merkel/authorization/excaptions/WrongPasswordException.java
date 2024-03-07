package ru.merkel.authorization.excaptions;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String massage) {
        super(massage);
    }
}
