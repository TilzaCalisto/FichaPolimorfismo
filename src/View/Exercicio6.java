/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author Dell
 */

import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.ContaModel;
import javax.swing.JOptionPane;

public class Exercicio6 extends javax.swing.JPanel {
    private ContaModel contaModel;

    public Exercicio6() {
        initComponents();
        contaModel = new ContaModel();
        jTable1.setModel(contaModel);
        configurarComboBox();
        contaModel.carregarContas("contas.dat");
    }
    
    private void configurarComboBox() {
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[] { "Conta Corrente", "Conta Poupança" }));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 0, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema Bancário");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel2.setText("Número da Conta:");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel3.setText("Titular:");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel4.setText("Saldo Inicial:");

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel5.setText("Tipo de Conta:");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButton1.setText("Adicionar Conta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButton3.setText("Calcular Taxas Totais");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tipo", "Número", "Titular", "Saldo", "Taxa"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jTextField2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
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
        String numeroConta = jTextField1.getText().trim();
        String titular = jTextField2.getText().trim();
        String saldoStr = jTextField3.getText().trim();
        String tipo = (String) jComboBox1.getSelectedItem();
        
        // Validações
        if (numeroConta.isEmpty() || titular.isEmpty() || saldoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Verificar se número da conta já existe
        if (contaModel.numeroContaExiste(numeroConta)) {
            JOptionPane.showMessageDialog(this, "Número de conta já existe!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            double saldo = Double.parseDouble(saldoStr);
            if (saldo < 0) {
                JOptionPane.showMessageDialog(this, "Saldo não pode ser negativo!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            Conta conta;
            String detalhesTaxa = "";
            
            if ("Conta Corrente".equals(tipo)) {
                conta = new ContaCorrente(numeroConta, titular, saldo);
                detalhesTaxa = "Taxa fixa: 50,00 MT";
            } else {
                conta = new ContaPoupanca(numeroConta, titular, saldo);
                double taxa = conta.calcularTaxa();
                detalhesTaxa = String.format("Taxa: 0.5%% sobre saldo = %,.2f MT", taxa);
            }
            
            contaModel.adicionarConta(conta);
            
            // Limpar campos
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            
            JOptionPane.showMessageDialog(this, 
                "Conta criada com sucesso!\n" +
                "Tipo: " + tipo + "\n" +
                "Número: " + numeroConta + "\n" +
                "Titular: " + titular + "\n" +
                "Saldo: " + String.format("%,.2f MT", saldo) + "\n" +
                detalhesTaxa,
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Saldo deve ser um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            if (contaModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Não há contas para salvar!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            contaModel.salvarContas("contas.dat");
            
            JOptionPane.showMessageDialog(this, 
                "Contas salvas com sucesso!\n" +
                "Total: " + contaModel.getRowCount() + " contas\n" +
                "Arquivo: contas.dat",
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (contaModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Não há contas cadastradas!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // ⭐⭐ RECURSIVIDADE - Calcula taxas totais ⭐⭐
        double taxasTotais = contaModel.calcularTaxasTotaisRecursivamente();
        int totalContas = contaModel.getRowCount();
        int contasCorrente = contaModel.getTotalContasCorrente();
        int contasPoupanca = contaModel.getTotalContasPoupanca();
        double saldoTotal = contaModel.getSaldoTotal();
        
        JOptionPane.showMessageDialog(this, 
            "RELATÓRIO DE TAXAS BANCÁRIAS\n" +
            "Total de contas: " + totalContas + "\n" +
            "Contas Corrente: " + contasCorrente + "\n" +
            "Contas Poupança: " + contasPoupanca + "\n" +
            "Saldo total: " + String.format("%,.2f MT", saldoTotal) + "\n" +
            "Taxas totais: " + String.format("%,.2f MT", taxasTotais) + "\n" +
            "\n⭐ Cálculo feito com RECURSIVIDADE",
            "Taxas Bancárias", JOptionPane.INFORMATION_MESSAGE);
    }                                        

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;

    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame("Sistema Bancário - Exercício 6");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Exercicio6());
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}