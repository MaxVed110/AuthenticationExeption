package UserAuthentication;

public class WrongPasswordException extends RuntimeException {
    private static final String MESSAGE = "Введенный пароль не соответствует требуемому формату";

    public WrongPasswordException() {
        super(MESSAGE);
    }

    public WrongPasswordException(String admMessage) {
        super(admMessage);
    }
}
