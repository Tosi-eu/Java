package Santander.BankOperations;

public class ContaCorrente extends Conta {
    public ContaCorrente(int numero, Cliente cliente) {
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
        System.out.println("Extrato Conta Corrente #" + getNumero() + " - Saldo: R$" + saldo);
    }
}

