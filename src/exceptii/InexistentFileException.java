package exceptii;

public class InexistentFileException extends RuntimeException {
    public InexistentFileException() {
        super("file doesn't exist!");
    }
}