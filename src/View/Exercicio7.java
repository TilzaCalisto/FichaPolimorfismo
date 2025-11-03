/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author Dell
 */
import model.*;
import javax.swing.JOptionPane;
import java.util.List;

public class Exercicio7 extends javax.swing.JPanel {
    private RelatorioModel relatorioModel;
    
    private AnimalModel animalModel;
    private PessoaModel pessoaModel;
    private FuncionarioModel funcionarioModel;
    private VeiculoModel veiculoModel;
    private PagamentoModel pagamentoModel;
    private ContaModel contaModel;

    public Exercicio7() {
        initComponents();
        relatorioModel = new RelatorioModel();
        configurarComboBox();
        carregarDadosDeTodosExercicios();
    }
    
    private void configurarComboBox() {
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[] { 
                "Animais", "Pessoas", "Funcionários", "Veículos", 
                "Pagamentos", "Contas Bancárias", "Todos os Objetos"
            }));
    }
    
    private void carregarDadosDeTodosExercicios() {
        try {
            // Carrega dados de todos os exercícios
            animalModel = new AnimalModel();
            animalModel.carregarAnimais("animais.dat");
            
            pessoaModel = new PessoaModel();
            pessoaModel.carregarPessoas("pessoas.dat");
            
            funcionarioModel = new FuncionarioModel();
            funcionarioModel.carregarFuncionarios("funcionarios.dat");
            
            veiculoModel = new VeiculoModel();
            veiculoModel.carregarVeiculos("veiculos.dat");
            
            pagamentoModel = new PagamentoModel();
            pagamentoModel.carregarPagaveis("pagamentos.dat");
            
            contaModel = new ContaModel();
            contaModel.carregarContas("contas.dat");
            
            // Adiciona todos os objetos ao relatório
            relatorioModel.adicionarLista(animalModel.getAnimais());
            relatorioModel.adicionarLista(pessoaModel.getPessoas());
            relatorioModel.adicionarLista(funcionarioModel.getFuncionarios());
            relatorioModel.adicionarLista(veiculoModel.getVeiculos());
            relatorioModel.adicionarLista(pagamentoModel.getPagaveis());
            relatorioModel.adicionarLista(contaModel.getContas());
            
            jLabel3.setText("Dados carregados: " + relatorioModel.getTotalObjetos() + " objetos");
            
        } catch (Exception e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
            jLabel3.setText("Erro ao carregar dados");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 0, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Relatório Automático");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel2.setText("Tipo de Relatório:");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButton1.setText("Gerar Relatório");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButton2.setText("Exportar para .txt");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setFont(new java.awt.Font("Consolas", 0, 12));
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder("Relatório Gerado"));
        jScrollPane1.setViewportView(jTextArea1);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Carregando dados...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String tipoSelecionado = (String) jComboBox1.getSelectedItem();
        
        if (relatorioModel.getTotalObjetos() == 0) {
            JOptionPane.showMessageDialog(this, 
                "Nenhum dado carregado!\nVerifique se os outros exercícios têm dados salvos.",
                "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            // ⭐⭐ RECURSIVIDADE - Gera relatório agrupado por tipo ⭐⭐
            String relatorio = relatorioModel.gerarRelatorioRecursivamente(tipoSelecionado);
            jTextArea1.setText(relatorio);
            
            JOptionPane.showMessageDialog(this, 
                "Relatório gerado com sucesso!\n" +
                "Tipo: " + tipoSelecionado + "\n" +
                "Itens encontrados: " + relatorioModel.getTotalPorTipo(tipoSelecionado) + "\n" +
                "\n⭐ Relatório gerado com RECURSIVIDADE",
                "Relatório", JOptionPane.INFORMATION_MESSAGE);
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao gerar relatório: " + e.getMessage(), 
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String tipoSelecionado = (String) jComboBox1.getSelectedItem();
        String relatorio = jTextArea1.getText();
        
        if (relatorio.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Gere um relatório primeiro!", 
                "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            String nomeArquivo = "relatorio_" + tipoSelecionado.toLowerCase().replace(" ", "_") + ".txt";
            relatorioModel.exportarParaArquivo(relatorio, nomeArquivo);
            
            JOptionPane.showMessageDialog(this, 
                "Relatório exportado com sucesso!\n" +
                "Arquivo: " + nomeArquivo,
                "Exportação", JOptionPane.INFORMATION_MESSAGE);
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao exportar: " + e.getMessage(), 
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }                                        

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;

    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame("Relatório Automático - Exercício 7");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Exercicio7());
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}