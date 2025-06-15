import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Por favor, digite o número da Agência: ");
        String agenciaInput = scanner.nextLine().replaceAll("\\D", "");
        agenciaInput = agenciaInput.length() > 4 ? agenciaInput.substring(0, 4) : agenciaInput;
        String agenciaFormatada = agenciaInput.length() == 4 
            ? agenciaInput.substring(0, 3) + "-" + agenciaInput.charAt(3) 
            : agenciaInput;

        System.out.print("Por favor, digite o número da Conta: ");
        String contaInput = scanner.nextLine().replaceAll("\\D", "");
        contaInput = contaInput.length() > 6 ? contaInput.substring(0, 6) : contaInput;
        String contaFormatada = contaInput.length() == 6 
            ? contaInput.substring(0, 5) + "-" + contaInput.charAt(5) 
            : contaInput;

        System.out.print("Por favor, digite o nome do Cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("Por favor, digite o saldo da Conta: ");
        double saldo = scanner.nextDouble();

        System.out.println("\nOlá " + nomeCliente + 
            ", obrigado por criar uma conta em nosso banco.");
        System.out.println("Sua agência é " + agenciaFormatada + 
            ", conta " + contaFormatada + 
            " e seu saldo de R$ " + saldo + " já está disponível para saque.");

        scanner.close();
    }
}
