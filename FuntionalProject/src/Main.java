import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String nomeArquivo = "dados.csv"; // Altere o caminho e nome do arquivo conforme necessário

        try {
            FileReader arquivo = new FileReader(nomeArquivo);
            try (BufferedReader leitor = new BufferedReader(arquivo)) {
                List<String[]> dados = new ArrayList<>();
                String linha;
                while ((linha = leitor.readLine()) != null) {
                    String[] valores = linha.split(",");
                    dados.add(valores);
                }

                // Leitura dos inteiros
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                String[] numeros = input.split(" ");
                int n1 = Integer.parseInt(numeros[0]);
                int n2 = Integer.parseInt(numeros[1]);
                int n3 = Integer.parseInt(numeros[2]);
                int n4 = Integer.parseInt(numeros[3]);

                // Filtrar os valores n4 maiores de Values[1]
                List<Integer> values1List = new ArrayList<>();
                for (String[] valores : dados) {
                    int value1 = Integer.parseInt(valores[1]);
                    values1List.add(value1);
                }
                Collections.sort(values1List, Collections.reverseOrder());
                List<Integer> topNValues1 = values1List.subList(0, Math.min(n4, values1List.size()));

                // Cálculo das informações solicitadas
                int somaActive = 0;
                for (String[] valores : dados) {
                    int confirmed = Integer.parseInt(valores[1]);
                    int active = Integer.parseInt(valores[4]);

                    if (confirmed >= n1) {
                        somaActive += active;
                    }
                }

                // Impressão das informações
                System.out.println(somaActive);
                for (String[] valores : dados) {
                    int value1 = Integer.parseInt(valores[1]);
                    if (topNValues1.contains(value1)) {
                        System.out.println(valores[0]);
                    }
                }
                
                ordenarLinhas(dados, n2);
                for(String[] valores: dados)
                {
                    System.out.println(valores[2]);
                }
                
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
    
    // Função para ordenar as n2 primeiras linhas com base em valores[4]
    //TODO: tendo ordenado a quarta coluna, temos agora que olhar para deaths(valores[2]) dos n3 países com menores confirmed(valores[1])
private static void ordenarLinhas(List<String[]> dados, int n2) {
    dados.sort(Comparator.comparingInt(values -> Integer.valueOf(values[4])));
    Collections.reverse(dados);
    dados.subList(n2, dados.size()).clear(); // Remove as linhas além das n2 primeiras
}
  
}
