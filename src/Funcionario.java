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
        atualizarSalarioBase(); // Atualiza o salário base quando o bônus muda
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    // Método para atualizar o salário base baseado no bônus
    private void atualizarSalarioBase() {
        // A cada 30 reais de bônus, aumenta o salário base em 100 reais
        int bonusMultiploDe30 = bonus / 30;
        this.salarioBase = this.salarioBase + (bonusMultiploDe30 * 100);
    }

    // Método para exibir detalhes do funcionário
    public void exibirDetalhes() {
        System.out.println("Nome: " + nome + ", Bonus: " + bonus + ", Salario Base: " + salarioBase);
    }
}
