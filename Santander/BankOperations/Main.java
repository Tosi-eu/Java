package Santander.BankOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();

        while (true) {
            System.out.println("\n======= MENU DE USUÁRIOS =======");
            System.out.println("1 - Criar novo usuário");
            System.out.println("2 - Listar todos os usuários");
            System.out.println("3 - Buscar usuário por documento");
            System.out.println("4 - Alterar nome de um usuário");
            System.out.println("5 - Remover usuário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("Tipo de cliente:");
                    System.out.println("1 - Cliente Físico");
                    System.out.println("2 - Cliente Jurídico");
                    System.out.print("Opção: ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Documento (CPF ou CNPJ): ");
                    String documento = scanner.nextLine();

                    try {
                        Cliente novoCliente = (tipo == 1)
                            ? new ClienteFisico(nome, documento)
                            : new ClienteJuridico(nome, documento);

                        clientes.add(novoCliente);
                        System.out.println("Usuário criado com sucesso!");
                    } catch (InvalidDocumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        System.out.println("Lista de clientes:");
                        for (Cliente c : clientes) {
                            System.out.println("- " + c.getNome() + " (" + c.getDocumento() + ")");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite o CPF ou CNPJ para buscar: ");
                    String docBusca = scanner.nextLine();
                    Cliente encontrado = buscarClientePorDocumento(clientes, docBusca);
                    if (encontrado != null) {
                        System.out.println("Cliente encontrado: " + encontrado.getNome());
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o CPF ou CNPJ do cliente a ser alterado: ");
                    String docAlvo = scanner.nextLine();
                    Cliente clienteParaAlterar = buscarClientePorDocumento(clientes, docAlvo);
                    if (clienteParaAlterar != null) {
                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine();
                        alterarNome(clienteParaAlterar, novoNome);
                        System.out.println("Nome alterado com sucesso.");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Digite o CPF ou CNPJ do cliente a ser removido: ");
                    String docRemover = scanner.nextLine();
                    Cliente clienteRemover = buscarClientePorDocumento(clientes, docRemover);
                    if (clienteRemover != null) {
                        clientes.remove(clienteRemover);
                        System.out.println("Cliente removido com sucesso.");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando sistema.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static Cliente buscarClientePorDocumento(List<Cliente> clientes, String documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento().equals(documento)) {
                return cliente;
            }
        }
        return null;
    }

    private static void alterarNome(Cliente cliente, String novoNome) {
        try {
            java.lang.reflect.Field field = Cliente.class.getDeclaredField("nome");
            field.setAccessible(true);
            field.set(cliente, novoNome);
        } catch (Exception e) {
            System.out.println("Erro ao alterar nome: " + e.getMessage());
        }
    }
}