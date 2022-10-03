package desafios.individuais.calculadora;

public class Emprestimos {

    public static int parcelarDuasVezes() {
        return 2;
    }

    public static int parcelarTresVezes() {

        return 3;
    }

    public static double taxaParcelamentoDuasVezes() {

        return 0.3;
    }

    public static double taxaParcelamentoTresVezes() {

        return 0.45;
    }

    public static void calcular(double valor, int parcelas) {

        if (parcelas == 2) {

            double valorFinal = valor + (valor * taxaParcelamentoDuasVezes());

            System.out.println("Valor de empréstimo para parcelamento em 2 vezes: R$ " + valorFinal);
        } else if (parcelas == 3) {

            double valorFinal = valor + (valor * taxaParcelamentoTresVezes());

            System.out.println("Valor de Empréstimo para parcelamento em 3 vezes: R$ " + valorFinal);
        } else {
            System.out.println("Quntidade de parcelas menor que o mínimo estabelecido");
        }

    }
}
