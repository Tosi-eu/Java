package desafios.individuais.desafio5;
import java.util.*;

public class Main5 {
  // IMPORTANTE: Para ler os dados de entrada do usuário, utilize a classe Scanner, 
// instanciando seu leitor da seguinte forma: "Scanner leitor = new Scanner(System.in);". 
// Por outro lado, para imprimir suas saídas, utilize System.out.print ou System.out.println. 
    public static void main(String[] args) {

      int[] elementos = {64, 137, -16, 43, 67, 81, -90, 212, 10, 75}; 
      boolean encontrou = false;
      int numero;

      try (Scanner leitor = new Scanner(System.in)){
          numero = leitor.nextInt();
        }

        for(int i = 0; i < elementos.length; i++){
          if(numero == elementos[i]){
            encontrou = true;
            System.out.print("Achei " + numero + " na posicao " + i);
            break;
          }else{
            continue;
          }
        }

        if(encontrou == false){
          System.out.print("Numero " + numero + " nao encontrado!");
        }

    }
}
