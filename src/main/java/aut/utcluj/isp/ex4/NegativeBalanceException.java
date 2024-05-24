package aut.utcluj.isp.ex4;

/**
 * @author stefan
 */



public class NegativeBalanceException extends RuntimeException {
    public NegativeBalanceException(String message) {
        super(message);
    }
}