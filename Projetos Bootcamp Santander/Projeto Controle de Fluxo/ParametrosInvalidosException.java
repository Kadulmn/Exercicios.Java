/*
Class exception para fazer o codigo funcionar corretamente
*/

public class ParametrosInvalidosException extends Exception {
    public ParametrosInvalidosException(String message) {
        super(message);
    }
}
