/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */

public class Freelancer implements Pagavel {
    private String nome;
    private double valorHora;
    private int horasTrabalhadas;
    
    public Freelancer(String nome, double valorHora, int horasTrabalhadas) {
        this.nome = nome;
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public double getValorHora() { return valorHora; }
    public void setValorHora(double valorHora) { this.valorHora = valorHora; }
    
    public int getHorasTrabalhadas() { return horasTrabalhadas; }
    public void setHorasTrabalhadas(int horasTrabalhadas) { this.horasTrabalhadas = horasTrabalhadas; }
    
    @Override
    public double calcularPagamento() {
        return valorHora * horasTrabalhadas;
    }
    
    @Override
    public String getTipoPagamento() {
        return "Pagamento por Hora";
    }
    
    @Override
    public String toString() {
        return String.format("Freelancer{nome='%s', valorHora=%.2f, horas=%d}", 
                           nome, valorHora, horasTrabalhadas);
    }
}
