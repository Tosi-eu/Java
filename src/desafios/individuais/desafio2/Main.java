package desafios.individuais.desafio2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int A, N, somaMultiplos = 0;

        Scanner input = new Scanner(System.in);
        A = input.nextInt();
        N = input.nextInt();

        for(int i = 0; i <= N; i++){
          if(i % A == 0)
            somaMultiplos += i;  
        }
        System.out.print(somaMultiplos);
    }
}