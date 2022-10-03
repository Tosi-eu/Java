package desafios.individuais.desafio3;
import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        int numero;
        int storeSum = 0;
        
        try (Scanner scan = new Scanner(System.in)) {
            numero = scan.nextInt();
        }

        storeSum = somatorio(numero);
        System.out.println(storeSum);

    }
    
    public static int somatorio(int numero) {
        if (numero == 0) {
            return 0;
        } else {
            return numero + somatorio(numero - 1);
     }
    }
}