package Santander.BankOperations;

public class ClienteJuridico extends Cliente {
    public ClienteJuridico(String nome, String cnpj) throws InvalidDocumentException {
        super(nome, cnpj);
    }

    @Override
    protected void validarDocumento(String cnpj) throws InvalidDocumentException {
        if (cnpj == null || !cnpj.matches("\\d{14}")) {
            throw new InvalidDocumentException("CNPJ inválido.");
        }
    }
}

