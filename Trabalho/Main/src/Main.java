import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Scanner scanner = new Scanner(System.in);
        boolean executar = true;

        while (executar) {
            exibirMenu();
            int opcao = obterOpcao(scanner);

            switch (opcao) {
                case 1:
                    criarProduto(scanner, produtoDAO);
                    break;
                case 2:
                    lerProduto(scanner, produtoDAO);
                    break;
                case 3:
                    atualizarProduto(scanner, produtoDAO);
                    break;
                case 4:
                    deletarProduto(scanner, produtoDAO);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    executar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n===== Menu de Operações =====");
        System.out.println("1. Criar Produto");
        System.out.println("2. Ler Produto");
        System.out.println("3. Atualizar Produto");
        System.out.println("4. Deletar Produto");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int obterOpcao(Scanner scanner) {
        int opcao = -1;
        try {
            opcao = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
        }
        return opcao;
    }

    private static void criarProduto(Scanner scanner, ProdutoDAO produtoDAO) {
        try {
            System.out.print("Digite o ID do produto: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Digite o nome do produto: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o preço do produto: ");
            double preco = scanner.nextDouble();
            scanner.nextLine(); 

            Produto novoProduto = new Produto(id, nome, preco);
            produtoDAO.create(novoProduto);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira os dados corretos.");
            scanner.nextLine(); 
        }
    }

    private static void lerProduto(Scanner scanner, ProdutoDAO produtoDAO) {
        try {
            System.out.print("Digite o ID do produto para leitura: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            Produto produto = produtoDAO.read(id);
            if (produto != null) {
                System.out.println("Produto encontrado: " + produto);
            } else {
                System.out.println("Produto com ID " + id + " não encontrado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira um ID válido.");
            scanner.nextLine(); 
        }
    }

    private static void atualizarProduto(Scanner scanner, ProdutoDAO produtoDAO) {
        try {
            System.out.print("Digite o ID do produto para atualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Digite o novo nome do produto: ");
            String novoNome = scanner.nextLine();

            System.out.print("Digite o novo preço do produto: ");
            double novoPreco = scanner.nextDouble();
            scanner.nextLine(); 

            produtoDAO.update(id, novoNome, novoPreco);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira os dados corretos.");
            scanner.nextLine(); 
        }
    }

    private static void deletarProduto(Scanner scanner, ProdutoDAO produtoDAO) {
        try {
            System.out.print("Digite o ID do produto para deletar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            produtoDAO.delete(id);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira um ID válido.");
            scanner.nextLine(); 
        }
    }
}
