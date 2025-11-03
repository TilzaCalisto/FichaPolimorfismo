package model;

import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioModel extends AbstractTableModel {
    private List<Funcionario> funcionarios;
    private final String[] colunas = {"Tipo", "Nome", "Salário", "Departamento"};
    
    public FuncionarioModel() {
        this.funcionarios = new ArrayList<>();
    }
    
    // ========== MÉTODOS TABLEMODEL ==========
    @Override
    public int getRowCount() { return funcionarios.size(); }
    
    @Override
    public int getColumnCount() { return colunas.length; }
    
    @Override
    public String getColumnName(int column) { return colunas[column]; }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario func = funcionarios.get(rowIndex);
        switch (columnIndex) {
            case 0: return func.getClass().getSimpleName();
            case 1: return func.getNome();
            case 2: return String.format("%,.2f MT", func.getSalario());
            case 3: return (func instanceof Gerente) ? ((Gerente) func).getDepartamento() : "-";
            default: return null;
        }
    }
    
    // ========== MÉTODOS DE NEGÓCIO ==========
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        fireTableRowsInserted(funcionarios.size() - 1, funcionarios.size() - 1);
    }
    
    public Funcionario getFuncionario(int index) {
        return funcionarios.get(index);
    }
    
    public List<Funcionario> getFuncionarios() {
        return new ArrayList<>(funcionarios);
    }
    
    // ========== PERSISTÊNCIA ==========
    public void salvarFuncionarios(String arquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(arquivo))) {
            oos.writeObject(new ArrayList<>(funcionarios));
        }
    }
    
    @SuppressWarnings("unchecked")
    public void carregarFuncionarios(String arquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(arquivo))) {
            funcionarios = (List<Funcionario>) ois.readObject();
            fireTableDataChanged();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado - começando vazio");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar: " + e.getMessage());
        }
    }
    
    // ========== RECURSIVIDADE - Calcular Folha Total ==========
    public double calcularFolhaTotalRecursivamente() {
        return calcularFolhaRecursivamente(0);
    }
    
    private double calcularFolhaRecursivamente(int index) {
        if (index >= funcionarios.size()) {
            return 0.0;
        }
        return funcionarios.get(index).getSalario() + calcularFolhaRecursivamente(index + 1);
    }
    
    // Método para aumentar salário de gerentes
    public void aumentarSalarioGerentes(double percentual) {
        for (Funcionario func : funcionarios) {
            if (func instanceof Gerente) {
                ((Gerente) func).aumentarSalario(percentual);
            }
        }
        fireTableDataChanged();
    }
}