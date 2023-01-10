package UserAuthentication;

public class WrongLoginException extends RuntimeException {
    private static final String MESSAGE = "Введенный логин не соответствует требуемому формату";

    public WrongLoginException() {
        super(MESSAGE);
    }

    public WrongLoginException(String admMessage) {
        super(admMessage);
    }
}
