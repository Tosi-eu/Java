package desafios.individuais.calculadora;

public class Calculadora {

    public static void somar(double numero1, double numero2) {

        double resultado = numero1 + numero2;

        System.out.println(numero1 + " + " + numero2 + " = " + resultado);
    }

    public static void subtrair(double numero1, double numero2) {

        double resultado = numero1 - numero2;

        System.out.println(numero1 + " - " + numero2 + " = " + resultado);
    }

    public static void multiplicar(double numero1, double numero2) {

        double resultado = numero1 * numero2;

        System.out.println(numero1 + " * " + numero2 + " = " + resultado);
    }

    public static void  dividir(double numero1, double numero2) {

        double resultado = numero1 / numero2;

        System.out.println(numero1 + " / " + numero2 + " = " + resultado);
    }

}
