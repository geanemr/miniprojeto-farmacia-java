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
}
