import java.util.ArrayList;
import java.util.List;

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

        // Criação do objeto Farmacia com listas de medicamentos e funcionários, o lucro será 0
        Farmacia farmacia = new Farmacia(medicamentos, funcionarios);

        // Exibe o lucro inicial da farmácia
        System.out.println("Lucro inicial da Farmacia: " + farmacia.getLucro());
        
        // Exibe os medicamentos da farmácia
        System.out.println("Medicamentos: ");
        for (Medicamento med : farmacia.getMedicamentos()) {
            System.out.println("Nome: " + med.getNome() + ", Quantidade: " + med.getQuantidadeEmEstoque() + ", Preco: " + med.getPreco());
        }
        
        // Exibe os funcionários da farmácia
        System.out.println("Funcionarios: ");
        for (Funcionario func : farmacia.getFuncionarios()) {
            System.out.println("Nome: " + func.getNome() + ", Bonus: " + func.getBonus() + ", Salario Base: " + func.getSalarioBase());
        }
        
        // Realiza uma compra de Paracetamol pelo funcionário João
        farmacia.comprarMedicamento("Paracetamol", func1);
    }
}
