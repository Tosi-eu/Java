package desafios.individuais.areas;

public class Areas {

    final static double pi = 3.14;
    public static void area(double lado) {

        System.out.println("Área do Quadrado: " + lado * lado + " m2");
    }

    public static void area(float lado1, double lado2) {

        System.out.println("Área do Retângulo: " + lado1 * lado2 + " m2");
    }

    public static void area(double baseMaior, double baseMenor, double altura) {

        System.out.println("Área do Trapézio:" + ((baseMaior+baseMenor)*altura) / 2 + " m2");
    }

    public static void area(float diagonal1, float diagonal2) {

        System.out.println("Área do losango:" + (diagonal1 * diagonal2)/2 + " m2");
    }

    public static void area(double raio, double geratriz) {

        System.out.println("Área do cone:" + pi * raio * (raio + geratriz) + " m2");
  }

    public static void areaEsfera(float raio){

        System.out.println("Área da esfera: " + 4 *  pi * (raio * raio) + " m2");
  }

    public static void area(float raio){

        System.out.println("Área do círculo: " + pi * (raio * raio) + " m2");
}

}
