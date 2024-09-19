public class Funcionario {
    // Propriedades da classe Funcionario
    private String nome;
    private int bonus;
    private double salarioBase;

    // Construtor com bônus inicial 0
    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.bonus = 0; // Bonus inicial 0
        this.salarioBase = salarioBase;
    }

    // Métodos getters e setters para acessar e modificar as propriedades
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    // Método para exibir detalhes do funcionário
    public void exibirDetalhes() {
        System.out.println("Nome: " + nome + ", Bonus: " + bonus + ", Salario Base: " + salarioBase);
    }
}
