package desafios.individuais.areas.AreaRetorno;
import java.math.*;
public class Mainly {
  public static void main(String[] args) {

    // Retornos
    double areaQuadrado = Notaveis.area(3);
    System.out.println("Área do quadrado:" + areaQuadrado + " m2");

    double areaRetangulo = Notaveis.area(5,5);
    System.out.println("Área do retângulo:" + areaRetangulo + " m2");

    double areaTrapezio = Notaveis.area(7,8,9);
    System.out.println("Área do trapézio:" + areaTrapezio + " m2");

    double areaCone = Notaveis.area(5f, 12);
    System.out.println("Área do cone:" + Math.ceil(areaCone) + " m2");

    double areaCirculo = Notaveis.area(5f);
    System.out.println("Área da esfera:" + areaCirculo + " m2");
 }
}
