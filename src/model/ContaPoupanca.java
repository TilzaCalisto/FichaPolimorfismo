/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */

public class ContaPoupanca implements Conta {
    private String numeroConta;
    private String titular;
    private double saldo;
    private static final double TAXA_PERCENTUAL = 0.5; // 0.5% sobre o saldo
    
    public ContaPoupanca(String numeroConta, String titular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }
    
    // Getters e Setters
    public String getNumeroConta() { return numeroConta; }
    public void setNumeroConta(String numeroConta) { this.numeroConta = numeroConta; }
    
    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }
    
    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }
    
    @Override
    public double calcularTaxa() {
        return saldo * (TAXA_PERCENTUAL / 100); // 0.5% sobre o saldo
    }
    
    @Override
    public String getTipoConta() {
        return "Conta Poupança";
    }
    
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }
    
    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }
    
    public void renderJuros(double taxa) {
        if (taxa > 0) {
            saldo += saldo * (taxa / 100);
        }
    }
    
    @Override
    public String toString() {
        return String.format("ContaPoupanca{numero='%s', titular='%s', saldo=%.2f}", 
                           numeroConta, titular, saldo);
    }
}