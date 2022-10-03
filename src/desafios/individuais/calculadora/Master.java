package desafios.individuais.calculadora;

public class Master {

    public static void main(String[] args) {

        // Calculadora
        Calculadora.somar(3, 6);
        Calculadora.subtrair(9, 1.8);
        Calculadora.multiplicar(7, 8);
        Calculadora.dividir(5, 2.5);

        // Mensagens
        Mensagens.mensagemPeriodoDoDia(4);
        Mensagens.mensagemPeriodoDoDia(13);
        Mensagens.mensagemPeriodoDoDia(23);

        // Empréstimos
        Emprestimos.calcular(1000, Emprestimos.parcelarDuasVezes());
        Emprestimos.calcular(1000, Emprestimos.parcelarTresVezes());
        Emprestimos.calcular(1000, 5);

    }
}
