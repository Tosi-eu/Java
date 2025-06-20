package Santander.BankOperations;

public abstract class Cliente {
    private String nome;
    private String documento;

    public Cliente(String nome, String documento) throws InvalidDocumentException {
        this.nome = nome;
        this.documento = documento;
        validarDocumento(documento);
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    protected abstract void validarDocumento(String documento) throws InvalidDocumentException;

    @Override
    public String toString() {
        return nome + " (" + documento + ")";
    }
}
