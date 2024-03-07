package ru.merkel.authorization.excaptions;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException(String massage) {
        super(massage);
    }
}
