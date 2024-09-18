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
        
        // Adiciona os medicamentos a uma lista
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos.add(med1);
        medicamentos.add(med2);

        // Criação de objetos Funcionario
        Funcionario func1 = new Funcionario();
        func1.setNome("Joao");
        func1.setBonus(500);
        func1.setSalarioBase(3000.00);

        Funcionario func2 = new Funcionario();
        func2.setNome("Maria");
        func2.setBonus(300);
        func2.setSalarioBase(2500.00);
        
        // Adiciona os funcionários a uma lista
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(func1);
        funcionarios.add(func2);

        // Criação do objeto Farmacia com listas de medicamentos e funcionários
        Farmacia farmacia = new Farmacia(medicamentos, funcionarios);

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nEscolha uma opcao:");
            System.out.println("1. Listar medicamentos e seus precos");
            System.out.println("2. Listar funcionarios e seus bonus");
            System.out.println("3. Buscar medicamento");
            System.out.println("4. Buscar funcionario");
            System.out.println("5. Comprar medicamento");
            System.out.println("0. Sair");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    // Listar medicamentos e seus preços
                    farmacia.listarMedicamentos();
                    break;
                case 2:
                    // Listar funcionários e seus bônus
                    farmacia.listarFuncionariosEBonus();
                    break;
                case 3:
                    // Buscar medicamento por nome
                    System.out.print("Digite o nome do medicamento: ");
                    String nomeMedicamento = scanner.nextLine();
                    farmacia.buscarMedicamento(nomeMedicamento);
                    break;
                case 4:
                    // Buscar funcionário por nome
                    System.out.print("Digite o nome do funcionario: ");
                    String nomeFuncionario = scanner.nextLine();
                    farmacia.buscarFuncionario(nomeFuncionario);
                    break;
                case 5:
                    // Comprar medicamento
                    System.out.print("Digite o nome do medicamento para compra: ");
                    String nomeMedicamentoCompra = scanner.nextLine();
                    System.out.print("Digite o nome do funcionario: ");
                    String nomeFuncionarioCompra = scanner.nextLine();
                    Funcionario funcionarioCompra = null;
                    for (Funcionario f : funcionarios) {
                        if (f.getNome().equalsIgnoreCase(nomeFuncionarioCompra)) {
                            funcionarioCompra = f;
                            break;
                        }
                    }
                    if (funcionarioCompra != null) {
                        farmacia.comprarMedicamento(nomeMedicamentoCompra, funcionarioCompra);
                    } else {
                        System.out.println("Funcionario nao encontrado.");
                    }
                    break;
                case 0:
                    // Sair do programa
                    System.out.println("Saindo...");
                    break;
                default:
                    // Opção inválida
                    System.out.println("Opçao invalida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
