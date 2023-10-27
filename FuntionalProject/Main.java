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
                System.out.println("Soma de \"Active\" de países com \"Confirmed\" maior ou igual a " + n1 + ": " + somaActive);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
