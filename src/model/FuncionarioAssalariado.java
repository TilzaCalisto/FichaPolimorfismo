/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */

public class FuncionarioAssalariado implements Pagavel {
    private String nome;
    private double salarioMensal;
    
    public FuncionarioAssalariado(String nome, double salarioMensal) {
        this.nome = nome;
        this.salarioMensal = salarioMensal;
    }
    
    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public double getSalarioMensal() { return salarioMensal; }
    public void setSalarioMensal(double salarioMensal) { this.salarioMensal = salarioMensal; }
    
    @Override
    public double calcularPagamento() {
        return salarioMensal;
    }
    
    @Override
    public String getTipoPagamento() {
        return "Salário Fixo";
    }
    
    @Override
    public String toString() {
        return String.format("FuncionarioAssalariado{nome='%s', salario=%.2f}", nome, salarioMensal);
    }
}