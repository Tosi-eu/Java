package desafios.individuais.desafio4;

// IMPORTANTE: Para ler os dados de entrada do usuário, utilize a classe Scanner, 
// instanciando seu leitor da seguinte forma: "Scanner leitor = new Scanner(System.in);". 
// Por outro lado, para imprimir suas saídas, utilize System.out.print ou System.out.println.

import java.util.*;

public class Main4 {

    public static void main(String[] args) {

      int num;
        try (Scanner number = new Scanner(System.in)) {
          num = number.nextInt();
        }

        if(num % 3 == 0 && num % 5 == 0){
          System.out.println("FizzBuzz");
        }else if(num % 3 == 0){
          System.out.println("Fizz");
        }else if(num % 5 == 0){
          System.out.println("Buzz");
        }else{
          System.out.print(num);
        }

    }
}