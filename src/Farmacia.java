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
        System.out.println("Lista de Medicamentos e Precos:");
        for (Medicamento medicamento : medicamentos) {
            System.out.println("Nome: " + medicamento.getNome() + ", Preco: " + medicamento.getPreco());
        }
    }

    // Método para listar os funcionários e seus bônus
    public void listarFuncionarios() {
        System.out.println("Lista de Funcionarios, Salarios base e Bonus:");
        for (Funcionario funcionario : funcionarios) {
            funcionario.exibirDetalhes();
        }
    }

    // Método para comprar medicamento
    public void comprarMedicamento(String nomeMedicamento, Funcionario funcionario, int quantidade) {
        // Procura o medicamento na lista de medicamentos
        for (Medicamento medicamento : medicamentos) {
            if (medicamento.getNome().equalsIgnoreCase(nomeMedicamento)) {
                // Verifica se a quantidade solicitada está disponível em estoque
                if (medicamento.getQuantidadeEmEstoque() >= quantidade) {
                    // Remove a quantidade comprada do estoque
                    medicamento.setQuantidadeEmEstoque(medicamento.getQuantidadeEmEstoque() - quantidade);

                    // Adiciona o valor total dos medicamentos comprados ao lucro da farmácia
                    double valorCompra = medicamento.getPreco() * quantidade;
                    this.lucro += valorCompra;

                    // Aumenta o bônus do funcionário proporcionalmente à quantidade que foi comprada com ele(a)
                    funcionario.setBonus(funcionario.getBonus() + (10 * quantidade));

                    System.out.println("Compra realizada: " + quantidade + " unidade(s) de " + nomeMedicamento);
                    System.out.println(
                            "Novo estoque de " + nomeMedicamento + ": " + medicamento.getQuantidadeEmEstoque());
                    System.out.println("Novo lucro da farmacia: " + this.getLucro());
                    System.out.println(
                            "Novo bonus do funcionario " + funcionario.getNome() + ": " + funcionario.getBonus());
                    System.out.println("Salario base do funcionario " + funcionario.getNome() + ": "
                            + funcionario.getSalarioBase());
                    return; // Compra realizada, sair do método
                } else {
                    System.out.println("Estoque insuficiente de " + nomeMedicamento);
                    return; // Estoque insuficiente
                }
            }
        }
        System.out.println("Medicamento " + nomeMedicamento + " nao encontrado.");
    }

    // Método para limpar tudo
    public void limparTudo() {
        // Zera o lucro da farmácia
        this.lucro = 0;

        // Zera o bônus de todos os funcionários
        for (Funcionario funcionario : funcionarios) {
            funcionario.setBonus(0);
        }

        System.out.println("Todos os bonus foram zerados e o lucro da farmacia foi redefinido para 0.");
    }
}
