/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */

import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContaModel extends AbstractTableModel {
    private List<Conta> contas;
    private final String[] colunas = {"Tipo", "Número", "Titular", "Saldo", "Taxa"};
    
    public ContaModel() {
        this.contas = new ArrayList<>();
    }
    
    // ========== MÉTODOS TABLEMODEL ==========
    @Override
    public int getRowCount() { return contas.size(); }
    
    @Override
    public int getColumnCount() { return colunas.length; }
    
    @Override
    public String getColumnName(int column) { return colunas[column]; }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Conta conta = contas.get(rowIndex);
        switch (columnIndex) {
            case 0: return conta.getTipoConta();
            case 1: return conta.getNumeroConta();
            case 2: 
                if (conta instanceof ContaCorrente) {
                    return ((ContaCorrente) conta).getTitular();
                } else if (conta instanceof ContaPoupanca) {
                    return ((ContaPoupanca) conta).getTitular();
                }
                return "";
            case 3: return String.format("%,.2f MT", conta.getSaldo());
            case 4: return String.format("%,.2f MT", conta.calcularTaxa());
            default: return null;
        }
    }
    
    // ========== MÉTODOS DE NEGÓCIO ==========
    public void adicionarConta(Conta conta) {
        contas.add(conta);
        fireTableRowsInserted(contas.size() - 1, contas.size() - 1);
    }
    
    public Conta getConta(int index) {
        return contas.get(index);
    }
    
    public List<Conta> getContas() {
        return new ArrayList<>(contas);
    }
    
    // ========== PERSISTÊNCIA ==========
    public void salvarContas(String arquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(arquivo))) {
            oos.writeObject(new ArrayList<>(contas));
        }
    }
    
    @SuppressWarnings("unchecked")
    public void carregarContas(String arquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(arquivo))) {
            contas = (List<Conta>) ois.readObject();
            fireTableDataChanged();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado - começando vazio");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar: " + e.getMessage());
        }
    }
    
    // ========== RECURSIVIDADE - Calcular Taxas Totais ==========
    public double calcularTaxasTotaisRecursivamente() {
        return calcularTaxasRecursivamente(0);
    }
    
    private double calcularTaxasRecursivamente(int index) {
        if (index >= contas.size()) {
            return 0.0;
        }
        return contas.get(index).calcularTaxa() + calcularTaxasRecursivamente(index + 1);
    }
    
    // ========== MÉTODOS UTILITÁRIOS ==========
    public boolean numeroContaExiste(String numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return true;
            }
        }
        return false;
    }
    
    public int getTotalContasCorrente() {
        int count = 0;
        for (Conta conta : contas) {
            if (conta instanceof ContaCorrente) {
                count++;
            }
        }
        return count;
    }
    
    public int getTotalContasPoupanca() {
        int count = 0;
        for (Conta conta : contas) {
            if (conta instanceof ContaPoupanca) {
                count++;
            }
        }
        return count;
    }
    
    public double getSaldoTotal() {
        double total = 0.0;
        for (Conta conta : contas) {
            total += conta.getSaldo();
        }
        return total;
    }
}

