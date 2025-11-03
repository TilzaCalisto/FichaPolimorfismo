package model;

import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoModel extends AbstractTableModel {
    private List<Veiculo> veiculos;
    private final String[] colunas = {"Marca", "Modelo", "Tipo", "Detalhes"};
    
    public VeiculoModel() {
        this.veiculos = new ArrayList<>();
    }
    
    // Métodos do TableModel
    @Override
    public int getRowCount() {
        return veiculos.size();
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veiculo veiculo = veiculos.get(rowIndex);
        switch (columnIndex) {
            case 0: return veiculo.getMarca();
            case 1: return veiculo.getModelo();
            case 2: return veiculo.getClass().getSimpleName();
            case 3: 
                if (veiculo instanceof Carro) {
                    return ((Carro) veiculo).getPortas() + " portas";
                } else if (veiculo instanceof Bicicleta) {
                    return ((Bicicleta) veiculo).getMarchas() + " marchas";
                }
                return "";
            default: return null;
        }
    }
    
    // Métodos de negócio
    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        fireTableRowsInserted(veiculos.size() - 1, veiculos.size() - 1);
    }
    
    public Veiculo getVeiculo(int index) {
        return veiculos.get(index);
    }
    
    public List<Veiculo> getVeiculos() {
        return new ArrayList<>(veiculos);
    }
    
    // Persistência em arquivo
    public void salvarVeiculos(String arquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(arquivo))) {
            oos.writeObject(new ArrayList<>(veiculos));
        }
    }
    
    @SuppressWarnings("unchecked")
    public void carregarVeiculos(String arquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(arquivo))) {
            veiculos = (List<Veiculo>) ois.readObject();
            fireTableDataChanged();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado - começando vazio");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar veículos: " + e.getMessage());
        }
    }
    
    // Recursividade para mostrar movimentos
    public String mostrarMovimentosRecursivamente() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== MOVIMENTOS DOS VEÍCULOS (RECURSIVO) ===\n");
        mostrarMovimentosRecursivamente(0, sb);
        sb.append("==========================================\n");
        return sb.toString();
    }
    
    private void mostrarMovimentosRecursivamente(int index, StringBuilder sb) {
        if (index < veiculos.size()) {
            sb.append(veiculos.get(index).mover()).append("\n");
            mostrarMovimentosRecursivamente(index + 1, sb);
        }
    }
}