package Santander.BankOperations;

public abstract class Conta {
    private int numero;
    private Cliente cliente;
    protected double saldo;

    public Conta(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract void sacar(double valor);
    public abstract void depositar(double valor);
    public abstract void exibirExtrato();
}
