/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RelatorioModel {
    private List<Object> objetos;
    
    public RelatorioModel() {
        this.objetos = new ArrayList<>();
    }
    
    // ========== MÉTODOS PARA ADICIONAR OBJETOS ==========
    public void adicionarObjeto(Object objeto) {
        if (objeto != null) {
            objetos.add(objeto);
        }
    }
    
    public void adicionarLista(List<?> lista) {
        if (lista != null) {
            objetos.addAll(lista);
        }
    }
    
    public List<Object> getObjetos() {
        return new ArrayList<>(objetos);
    }
    
    public void limparObjetos() {
        objetos.clear();
    }
    
    // ========== RECURSIVIDADE - Gerar Relatório por Tipo ==========
    public String gerarRelatorioRecursivamente(String tipoSelecionado) {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("=== RELATÓRIO - ").append(tipoSelecionado).append(" ===\n\n");
        
        // Filtra objetos pelo tipo selecionado
        List<Object> objetosFiltrados = filtrarPorTipo(tipoSelecionado);
        
        if (objetosFiltrados.isEmpty()) {
            relatorio.append("Nenhum ").append(tipoSelecionado).append(" encontrado.\n");
        } else {
            gerarRelatorioRecursivamente(0, objetosFiltrados, relatorio, tipoSelecionado);
        }
        
        relatorio.append("\n====================================\n");
        relatorio.append("Total: ").append(objetosFiltrados.size()).append(" ").append(tipoSelecionado).append("(s)\n");
        
        return relatorio.toString();
    }
    
    private void gerarRelatorioRecursivamente(int index, List<Object> objetos, StringBuilder relatorio, String tipo) {
        if (index >= objetos.size()) {
            return;
        }
        
        Object obj = objetos.get(index);
        relatorio.append(formatarObjeto(obj, tipo)).append("\n");
        
        // Chamada recursiva
        gerarRelatorioRecursivamente(index + 1, objetos, relatorio, tipo);
    }
    
    // ========== FILTRAGEM POR TIPO ==========
    private List<Object> filtrarPorTipo(String tipo) {
        List<Object> filtrados = new ArrayList<>();
        
        for (Object obj : objetos) {
            if (correspondeAoFiltro(obj, tipo)) {
                filtrados.add(obj);
            }
        }
        
        return filtrados;
    }
    
    private boolean correspondeAoFiltro(Object obj, String tipo) {
        switch (tipo) {
            case "Animais":
                return obj instanceof Animal;
            case "Pessoas":
                return obj instanceof Pessoa;
            case "Funcionários":
                return obj instanceof Funcionario;
            case "Veículos":
                return obj instanceof Veiculo;
            case "Pagamentos":
                return obj instanceof Pagavel;
            case "Contas Bancárias":
                return obj instanceof Conta;
            case "Todos os Objetos":
                return true;
            default:
                return false;
        }
    }
    
    // ========== FORMATAÇÃO DE OBJETOS ==========
    private String formatarObjeto(Object obj, String tipo) {
        if (obj == null) return "Objeto nulo";
        
        StringBuilder sb = new StringBuilder();
        
        switch (tipo) {
            case "Animais":
                if (obj instanceof Animal) {
                    Animal animal = (Animal) obj;
                    sb.append("🐾 ").append(animal.getClass().getSimpleName())
                      .append(": ").append(animal.getNome())
                      .append(" (").append(animal.getIdade()).append(" anos)");
                }
                break;
                
            case "Pessoas":
                if (obj instanceof Pessoa) {
                    Pessoa pessoa = (Pessoa) obj;
                    sb.append("👤 ").append(pessoa.getClass().getSimpleName())
                      .append(": ").append(pessoa.getNome())
                      .append(" (").append(pessoa.getIdade()).append(" anos)");
                    
                    if (obj instanceof Aluno) {
                        Aluno aluno = (Aluno) obj;
                        sb.append(" - Matrícula: ").append(aluno.getMatricula());
                    }
                }
                break;
                
            case "Funcionários":
                if (obj instanceof Funcionario) {
                    Funcionario func = (Funcionario) obj;
                    sb.append("💼 ").append(func.getClass().getSimpleName())
                      .append(": ").append(func.getNome())
                      .append(" - Salário: ").append(String.format("%,.2f MT", func.getSalario()));
                    
                    if (obj instanceof Gerente) {
                        Gerente gerente = (Gerente) obj;
                        sb.append(" - Departamento: ").append(gerente.getDepartamento());
                    }
                }
                break;
                
            case "Veículos":
                if (obj instanceof Veiculo) {
                    Veiculo veiculo = (Veiculo) obj;
                    sb.append("🚗 ").append(veiculo.getClass().getSimpleName())
                      .append(": ").append(veiculo.getMarca())
                      .append(" ").append(veiculo.getModelo());
                      
                    if (obj instanceof Carro) {
                        Carro carro = (Carro) obj;
                        sb.append(" - ").append(carro.getPortas()).append(" portas");
                    } else if (obj instanceof Bicicleta) {
                        Bicicleta bicicleta = (Bicicleta) obj;
                        sb.append(" - ").append(bicicleta.getMarchas()).append(" marchas");
                    }
                }
                break;
                
            case "Pagamentos":
                if (obj instanceof Pagavel) {
                    Pagavel pagavel = (Pagavel) obj;
                    sb.append("💰 ").append(pagavel.getClass().getSimpleName())
                      .append(" - Pagamento: ").append(String.format("%,.2f MT", pagavel.calcularPagamento()))
                      .append(" (").append(pagavel.getTipoPagamento()).append(")");
                      
                    if (obj instanceof FuncionarioAssalariado) {
                        FuncionarioAssalariado func = (FuncionarioAssalariado) obj;
                        sb.append(" - Nome: ").append(func.getNome());
                    } else if (obj instanceof Freelancer) {
                        Freelancer freelancer = (Freelancer) obj;
                        sb.append(" - Nome: ").append(freelancer.getNome());
                    }
                }
                break;
                
            case "Contas Bancárias":
                if (obj instanceof Conta) {
                    Conta conta = (Conta) obj;
                    sb.append("🏦 ").append(conta.getTipoConta())
                      .append(": ").append(conta.getNumeroConta())
                      .append(" - Saldo: ").append(String.format("%,.2f MT", conta.getSaldo()))
                      .append(" - Taxa: ").append(String.format("%,.2f MT", conta.calcularTaxa()));
                }
                break;
                
            default:
                sb.append("📄 ").append(obj.getClass().getSimpleName())
                  .append(": ").append(obj.toString());
        }
        
        return sb.toString();
    }
    
    // ========== EXPORTAÇÃO PARA ARQUIVO ==========
    public void exportarParaArquivo(String conteudo, String arquivo) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo))) {
            writer.write(conteudo);
        }
    }
    
    // ========== ESTATÍSTICAS ==========
    public int getTotalObjetos() {
        return objetos.size();
    }
    
    public int getTotalPorTipo(String tipo) {
        int count = 0;
        for (Object obj : objetos) {
            if (correspondeAoFiltro(obj, tipo)) {
                count++;
            }
        }
        return count;
    }
}