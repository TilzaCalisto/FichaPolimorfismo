package model;

public class Gerente extends Funcionario {
    private String departamento;
    
    public Gerente(String nome, double salario, String departamento) {
        super(nome, salario);
        this.departamento = departamento;
    }
    
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    
    public void aumentarSalario(double percentual) {
        this.salario += this.salario * (percentual / 100);
    }
    
    @Override
    public String toString() {
        return String.format("Gerente{nome='%s', salario=%.2f, departamento='%s'}", 
                           nome, salario, departamento);
    }
}