package Santander.BankOperations;

public class ContaJuridica extends Conta {
    public ContaJuridica(int numero, Cliente cliente) {
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
        System.out.println("Extrato - Conta Jurídica #" + getNumero() + " | Empresa: " + getCliente().getNome() + " | Saldo: R$" + String.format("%.2f", saldo));
    }
}

