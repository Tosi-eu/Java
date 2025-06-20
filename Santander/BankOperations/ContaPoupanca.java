package Santander.BankOperations;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(int numero, Cliente cliente) {
        super(numero, cliente);
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saque inválido.");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    @Override
    public void exibirExtrato() {
        System.out.println("Extrato Conta Poupança #" + getNumero() + " - Saldo: R$" + saldo);
    }
}

