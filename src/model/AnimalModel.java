package model;

import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalModel extends AbstractTableModel {
    private List<Animal> animais;
    private final String[] colunas = {"Nome", "Idade", "Tipo"};
    
    public AnimalModel() {
        this.animais = new ArrayList<>();
    }
    
    // Métodos do TableModel
    @Override
    public int getRowCount() {
        return animais.size();
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
        Animal animal = animais.get(rowIndex);
        switch (columnIndex) {
            case 0: return animal.getNome();
            case 1: return animal.getIdade();
            case 2: return animal.getClass().getSimpleName();
            default: return null;
        }
    }
    
    // Métodos de negócio
    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
        fireTableRowsInserted(animais.size() - 1, animais.size() - 1);
    }
    
    public void removerAnimal(int index) {
        animais.remove(index);
        fireTableRowsDeleted(index, index);
    }
    
    public Animal getAnimal(int index) {
        return animais.get(index);
    }
    
    public List<Animal> getAnimais() {
        return new ArrayList<>(animais);
    }
    
    // Persistência em arquivo
    public void salvarAnimais(String arquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(arquivo))) {
            oos.writeObject(new ArrayList<>(animais));
        }
    }
    
    // Método para carregar animais do arquivo
    @SuppressWarnings("unchecked")
    public void carregarAnimais(String arquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(arquivo))) {
            animais = (List<Animal>) ois.readObject();
            fireTableDataChanged(); // Atualiza a tabela
            System.out.println("Animais carregados: " + animais.size());
        } catch (FileNotFoundException e) {
            // Arquivo não existe ainda - é normal na primeira execução
            System.out.println("Arquivo não encontrado, começando com lista vazia");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar animais: " + e.getMessage());
        }
    }
    
    // Recursividade para imprimir sons
    public void imprimirSonsRecursivamente() {
        System.out.println("=== SONS DOS ANIMAIS (RECURSIVO) ===");
        imprimirSonsRecursivamente(0);
        System.out.println("=====================================");
    }

    private void imprimirSonsRecursivamente(int index) {
        if (index < animais.size()) {
            animais.get(index).fazerSom();
            imprimirSonsRecursivamente(index + 1); // Chamada recursiva
        }
    }   
    
    
    
}