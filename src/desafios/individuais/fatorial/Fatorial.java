package desafios.individuais.fatorial;
import java.util.*;

public class Fatorial {

  public static void main(String[] args) {
    int numero;
    int storeSum = 0;
    
    try (Scanner scan = new Scanner(System.in)) {
        numero = scan.nextInt();
    }

    storeSum = fatorial(numero);
    System.out.println(storeSum);

}

public static int fatorial(int numero) {
  int fatorial = 1;
  
    if (numero < 0)
        return 0;

    for(int i = numero; i >= 1; i--){
      fatorial *= i;
    }
    return fatorial;
  }
  
}
