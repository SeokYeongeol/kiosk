package org.example.kiosk7;

public class BadInputException extends RuntimeException {
    public BadInputException() {
        super("잘못된 값을 입력하였습니다.");
    }
}
