package Santander.BankOperations;

public class InvalidDocumentException extends Exception {
    public InvalidDocumentException(String mensagem) {
        super(mensagem);
    }
}
