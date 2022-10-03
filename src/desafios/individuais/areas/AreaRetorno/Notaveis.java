package desafios.individuais.areas.AreaRetorno;

public class Notaveis {
    final static double pi = 3.14;
    public static double area(double lado) {

        return lado * lado;
    }

    public static double area(double lado1, double lado2) {

        return lado1 * lado2;
    }

    public static double area(double baseMaior, double baseMenor, double altura) {

        return ((baseMaior+baseMenor)*altura) / 2;
    }

    public static double area(float raio){

        return pi * (raio * raio);
}

    public static double area(float raio, int geratriz){

        return pi * raio * (raio + geratriz);
}


}
