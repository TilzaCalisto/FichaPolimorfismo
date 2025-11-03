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

public class PagamentoModel extends AbstractTableModel {
    private List<Pagavel> pagaveis;
    private final String[] colunas = {"Tipo", "Nome", "Detalhes", "Pagamento", "Tipo Pagamento"};
    
    public PagamentoModel() {
        this.pagaveis = new ArrayList<>();
    }
    
    // ========== MÉTODOS TABLEMODEL ==========
    @Override
    public int getRowCount() { return pagaveis.size(); }
    
    @Override
    public int getColumnCount() { return colunas.length; }
    
    @Override
    public String getColumnName(int column) { return colunas[column]; }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pagavel pagavel = pagaveis.get(rowIndex);
        switch (columnIndex) {
            case 0: return pagavel.getClass().getSimpleName();
            case 1: 
                if (pagavel instanceof FuncionarioAssalariado) {
                    return ((FuncionarioAssalariado) pagavel).getNome();
                } else if (pagavel instanceof Freelancer) {
                    return ((Freelancer) pagavel).getNome();
                }
                return "";
            case 2:
                if (pagavel instanceof FuncionarioAssalariado) {
                    return String.format("Salário: %,.2f MT", 
                        ((FuncionarioAssalariado) pagavel).getSalarioMensal());
                } else if (pagavel instanceof Freelancer) {
                    Freelancer freelancer = (Freelancer) pagavel;
                    return String.format("%d horas × %,.2f MT/hora", 
                        freelancer.getHorasTrabalhadas(), freelancer.getValorHora());
                }
                return "";
            case 3: return String.format("%,.2f MT", pagavel.calcularPagamento());
            case 4: return pagavel.getTipoPagamento();
            default: return null;
        }
    }
    
    // ========== MÉTODOS DE NEGÓCIO ==========
    public void adicionarPagavel(Pagavel pagavel) {
        pagaveis.add(pagavel);
        fireTableRowsInserted(pagaveis.size() - 1, pagaveis.size() - 1);
    }
    
    public Pagavel getPagavel(int index) {
        return pagaveis.get(index);
    }
    
    public List<Pagavel> getPagaveis() {
        return new ArrayList<>(pagaveis);
    }
    
    // ========== PERSISTÊNCIA ==========
    public void salvarPagaveis(String arquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(arquivo))) {
            oos.writeObject(new ArrayList<>(pagaveis));
        }
    }
    
    @SuppressWarnings("unchecked")
    public void carregarPagaveis(String arquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(arquivo))) {
            pagaveis = (List<Pagavel>) ois.readObject();
            fireTableDataChanged();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado - começando vazio");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar: " + e.getMessage());
        }
    }
    
    // ========== POLIMORFISMO - Calcular Total de Pagamentos ==========
    public double calcularTotalPagamentos() {
        double total = 0.0;
        for (Pagavel pagavel : pagaveis) {
            total += pagavel.calcularPagamento(); // ⭐⭐ POLIMORFISMO ⭐⭐
        }
        return total;
    }
    
    // ========== ESTATÍSTICAS ==========
    public int getTotalFuncionariosAssalariados() {
        int count = 0;
        for (Pagavel pagavel : pagaveis) {
            if (pagavel instanceof FuncionarioAssalariado) {
                count++;
            }
        }
        return count;
    }
    
    public int getTotalFreelancers() {
        int count = 0;
        for (Pagavel pagavel : pagaveis) {
            if (pagavel instanceof Freelancer) {
                count++;
            }
        }
        return count;
    }
}
