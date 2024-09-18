import java.util.List;

public class Farmacia {
    // Propriedades da classe Farmacia
    private double lucro;
    private List<Medicamento> medicamentos;
    private List<Funcionario> funcionarios;

    // Construtor que define o lucro inicial como 0
    public Farmacia(List<Medicamento> medicamentos, List<Funcionario> funcionarios) {
        this.lucro = 0;
        this.medicamentos = medicamentos;
        this.funcionarios = funcionarios;
    }

    // Métodos getters e setters para acessar e modificar as propriedades
    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    // Método para listar os medicamentos e seus preços
    public void listarMedicamentos() {
        System.out.println("Lista de Medicamentos e Preços:");
        for (Medicamento medicamento : medicamentos) {
            System.out.println("Nome: " + medicamento.getNome() + ", Preço: " + medicamento.getPreco() +
                    ", Quantidade em Estoque: " + medicamento.getQuantidadeEmEstoque());
        }
    }

    // Método para listar os funcionários e seus bônus
    public void listarFuncionariosEBonus() {
        System.out.println("Lista de Funcionários e Bônus:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome() + ", Bônus: " + funcionario.getBonus() +
                    ", Salário Base: " + funcionario.getSalarioBase());
        }
    }

    // Método para buscar um medicamento por nome
    public void buscarMedicamento(String nomeMedicamento) {
        for (Medicamento medicamento : medicamentos) {
            if (medicamento.getNome().equalsIgnoreCase(nomeMedicamento)) {
                System.out.println("Detalhes do Medicamento:");
                System.out.println("Nome: " + medicamento.getNome());
                System.out.println("Preço: " + medicamento.getPreco());
                System.out.println("Quantidade em Estoque: " + medicamento.getQuantidadeEmEstoque());
                return;
            }
        }
        System.out.println("Medicamento não encontrado.");
    }

    // Método para buscar um funcionário por nome
    public void buscarFuncionario(String nomeFuncionario) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nomeFuncionario)) {
                System.out.println("Detalhes do Funcionário:");
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Bônus: " + funcionario.getBonus());
                System.out.println("Salário Base: " + funcionario.getSalarioBase());
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    // Método para comprar medicamento
    public void comprarMedicamento(String nomeMedicamento, Funcionario funcionario) {
        // Procura o medicamento na lista de medicamentos
        for (Medicamento medicamento : medicamentos) {
            if (medicamento.getNome().equalsIgnoreCase(nomeMedicamento)) {
                // Verifica se o medicamento está disponível em estoque
                if (medicamento.getQuantidadeEmEstoque() > 0) {
                    // Remove 1 unidade do estoque
                    medicamento.setQuantidadeEmEstoque(medicamento.getQuantidadeEmEstoque() - 1);

                    // Adiciona o valor do medicamento ao lucro da farmácia
                    this.lucro += medicamento.getPreco();

                    // Aumenta o bônus do funcionário em 10
                    funcionario.setBonus(funcionario.getBonus() + 10);

                    System.out.println("Compra realizada: " + nomeMedicamento);
                    System.out.println(
                            "Novo estoque de " + nomeMedicamento + ": " + medicamento.getQuantidadeEmEstoque());
                    System.out.println("Novo lucro da farmácia: " + this.getLucro());
                    System.out.println(
                            "Novo bônus do funcionário " + funcionario.getNome() + ": " + funcionario.getBonus());
                    return; // Compra realizada, sair do método
                } else {
                    System.out.println("Estoque insuficiente de " + nomeMedicamento);
                    return; // Estoque insuficiente
                }
            }
        }
        System.out.println("Medicamento " + nomeMedicamento + " não encontrado.");
    }
}
