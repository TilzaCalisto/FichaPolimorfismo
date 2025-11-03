package model;

import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaModel extends AbstractTableModel {
    private List<Pessoa> pessoas;
    private final String[] colunas = {"Tipo", "Nome", "Idade", "Matrícula"};
    
    public PessoaModel() {
        this.pessoas = new ArrayList<>();
    }
    
    // ========== MÉTODOS DO TABLEMODEL ==========
    
    @Override
    public int getRowCount() {
        return pessoas.size();
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
        if (rowIndex >= pessoas.size()) {
            return null;
        }
        
        Pessoa pessoa = pessoas.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return pessoa.getClass().getSimpleName();
            case 1: 
                return pessoa.getNome();
            case 2: 
                return pessoa.getIdade();
            case 3: 
                if (pessoa instanceof Aluno) {
                    return ((Aluno) pessoa).getMatricula();
                }
                return ""; // Pessoa comum não tem matrícula
            default: 
                return null;
        }
    }
    
    // ========== MÉTODOS DE NEGÓCIO ==========
    
    public void adicionarPessoa(Pessoa pessoa) {
        if (pessoa != null) {
            pessoas.add(pessoa);
            fireTableRowsInserted(pessoas.size() - 1, pessoas.size() - 1);
        }
    }
    
    public void removerPessoa(int index) {
        if (index >= 0 && index < pessoas.size()) {
            pessoas.remove(index);
            fireTableRowsDeleted(index, index);
        }
    }
    
    public Pessoa getPessoa(int index) {
        if (index >= 0 && index < pessoas.size()) {
            return pessoas.get(index);
        }
        return null;
    }
    
    public List<Pessoa> getPessoas() {
        return new ArrayList<>(pessoas);
    }
    
    public int getTotalPessoas() {
        return pessoas.size();
    }
    
    public int getTotalAlunos() {
        int count = 0;
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Aluno) {
                count++;
            }
        }
        return count;
    }
    
    // ========== PERSISTÊNCIA EM FICHEIRO ==========
    
    public void salvarPessoas(String arquivo) throws IOException {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa para salvar.");
            return;
        }
        
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(arquivo))) {
            oos.writeObject(new ArrayList<>(pessoas));
            System.out.println("✅ " + pessoas.size() + " pessoas salvas em " + arquivo);
        } catch (IOException e) {
            System.err.println("❌ Erro ao salvar pessoas: " + e.getMessage());
            throw e;
        }
    }
    
    @SuppressWarnings("unchecked")
    public void carregarPessoas(String arquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(arquivo))) {
            
            List<Pessoa> pessoasCarregadas = (List<Pessoa>) ois.readObject();
            pessoas.clear();
            pessoas.addAll(pessoasCarregadas);
            
            fireTableDataChanged(); // Atualiza a tabela
            System.out.println("✅ " + pessoas.size() + " pessoas carregadas de " + arquivo);
            
        } catch (FileNotFoundException e) {
            System.out.println("📝 Ficheiro " + arquivo + " não encontrado. Começando com lista vazia.");
        } catch (IOException e) {
            System.err.println("❌ Erro de I/O ao carregar pessoas: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Erro: Classe não encontrada ao carregar pessoas: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Erro inesperado ao carregar pessoas: " + e.getMessage());
        }
    }
    
    // ========== MÉTODOS UTILITÁRIOS ==========
    
    public void limparDados() {
        if (!pessoas.isEmpty()) {
            int tamanho = pessoas.size();
            pessoas.clear();
            fireTableRowsDeleted(0, tamanho - 1);
            System.out.println("🗑️ Todos os dados foram limpos.");
        }
    }
    
    public boolean existeMatricula(String matricula) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Aluno) {
                Aluno aluno = (Aluno) pessoa;
                if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "PessoaModel{" + "pessoas=" + pessoas.size() + 
               ", alunos=" + getTotalAlunos() + 
               ", pessoasComuns=" + (pessoas.size() - getTotalAlunos()) + "}";
    }
}