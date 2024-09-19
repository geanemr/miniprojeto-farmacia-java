import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criação de objetos Medicamento
        Medicamento med1 = new Medicamento();
        med1.setNome("Paracetamol");
        med1.setQuantidadeEmEstoque(100);
        med1.setPreco(5.50);

        Medicamento med2 = new Medicamento();
        med2.setNome("Ibuprofeno");
        med2.setQuantidadeEmEstoque(50);
        med2.setPreco(7.00);

        Medicamento med3 = new Medicamento();
        med3.setNome("Dipirona");
        med3.setQuantidadeEmEstoque(75);
        med3.setPreco(4.00);

        Medicamento med4 = new Medicamento();
        med4.setNome("Omeprazol");
        med4.setQuantidadeEmEstoque(25);
        med4.setPreco(10.00);

        // Adiciona os medicamentos a uma lista
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos.add(med1);
        medicamentos.add(med2);
        medicamentos.add(med3);
        medicamentos.add(med4);

        // Criação de objetos Funcionario
        Funcionario func1 = new Funcionario("Joao", 2500.00);
        Funcionario func2 = new Funcionario("Maria", 2600.00);
        Funcionario func3 = new Funcionario("Pedro", 2600.00);
        Funcionario func4 = new Funcionario("Ana", 2700.00);

        // Adiciona os funcionários a uma lista
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(func1);
        funcionarios.add(func2);
        funcionarios.add(func3);
        funcionarios.add(func4);

        // Criação do objeto Farmacia com listas de medicamentos e funcionários, o lucro
        // será 0
        Farmacia farmacia = new Farmacia(medicamentos, funcionarios);

        // Criação do scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opcao:");
            System.out.println("1. Listar medicamentos e seus precos");
            System.out.println("2. Listar funcionarios, seus salarios base e bonus");
            System.out.println("3. Buscar medicamento");
            System.out.println("4. Buscar funcionario");
            System.out.println("5. Comprar medicamento");
            System.out.println("6. Limpar tudo");
            System.out.println("0. Sair");
            System.out.print("Opcao: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    farmacia.listarMedicamentos();
                    break;
                case 2:
                    farmacia.listarFuncionarios();
                    break;
                case 3:
                    System.out.print("Digite o nome do medicamento: ");
                    String nomeMedicamento = scanner.nextLine();
                    Medicamento medicamento = farmacia.getMedicamentos().stream()
                            .filter(m -> m.getNome().equalsIgnoreCase(nomeMedicamento))
                            .findFirst()
                            .orElse(null);
                    if (medicamento != null) {
                        System.out.println("Nome: " + medicamento.getNome() +
                                ", Quantidade em Estoque: " + medicamento.getQuantidadeEmEstoque() +
                                ", Preco: " + medicamento.getPreco());
                    } else {
                        System.out.println("Medicamento nao encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome do funcionario: ");
                    String nomeFuncionario = scanner.nextLine();
                    Funcionario funcionario = farmacia.getFuncionarios().stream()
                            .filter(f -> f.getNome().equalsIgnoreCase(nomeFuncionario))
                            .findFirst()
                            .orElse(null);
                    if (funcionario != null) {
                        funcionario.exibirDetalhes();
                    } else {
                        System.out.println("Funcionario nao encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o nome do medicamento para compra: ");
                    String nomeMedicamentoCompra = scanner.nextLine();
                    if (farmacia.getMedicamentos().stream()
                            .noneMatch(m -> m.getNome().equalsIgnoreCase(nomeMedicamentoCompra))) {
                        System.out.println("Medicamento nao encontrado.");
                        break;
                    }
                    System.out.print("Digite a quantidade de medicamentos para comprar: ");
                    int quantidadeCompra = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do scanner

                    System.out.print("Digite o nome do funcionario: ");
                    String nomeFuncionarioCompra = scanner.nextLine();
                    Funcionario funcionarioCompra = farmacia.getFuncionarios().stream()
                            .filter(f -> f.getNome().equalsIgnoreCase(nomeFuncionarioCompra))
                            .findFirst()
                            .orElse(null);
                    if (funcionarioCompra != null) {
                        farmacia.comprarMedicamento(nomeMedicamentoCompra, funcionarioCompra, quantidadeCompra);
                    } else {
                        System.out.println("Funcionario nao encontrado.");
                    }
                    break;
                case 6:
                    farmacia.limparTudo();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return; // Sai do loop e encerra o programa
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
                    break;
            }
        }
    }
}
