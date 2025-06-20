package Santander.BankOperations;

public class ClienteFisico extends Cliente {
    public ClienteFisico(String nome, String cpf) throws InvalidDocumentException {
        super(nome, cpf);
    }

    @Override
    protected void validarDocumento(String cpf) throws InvalidDocumentException {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new InvalidDocumentException("CPF inválido.");
        }
    }
}
