package View;

import model.Funcionario;
import model.Gerente;
import model.FuncionarioModel;
import javax.swing.JOptionPane;

public class Exercicio4 extends javax.swing.JPanel {
    private FuncionarioModel funcionarioModel;

    public Exercicio4() {
        initComponents();
        funcionarioModel = new FuncionarioModel();
        jTable1.setModel(funcionarioModel);
        configurarComboBox();
        funcionarioModel.carregarFuncionarios("funcionarios.dat");
    }
    
    private void configurarComboBox() {
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[] { "Funcionário", "Gerente" }));
        
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[] { "Vendas", "TI", "RH", "Financeiro", "Produção" }));
        
        // Listener para mostrar/esconder departamento
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarVisibilidadeDepartamento();
            }
        });
        
        // Configurar estado inicial
        atualizarVisibilidadeDepartamento();
    }
    
    private void atualizarVisibilidadeDepartamento() {
        String tipo = (String) jComboBox1.getSelectedItem();
        boolean ehGerente = "Gerente".equals(tipo);
        
        jLabel5.setVisible(ehGerente);
        jComboBox2.setVisible(ehGerente);
        
        if (!ehGerente) {
            jComboBox2.setSelectedIndex(0); // Reseta seleção
        }
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 0, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema de Funcionários");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel2.setText("Nome:");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel3.setText("Salário:");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel4.setText("Tipo:");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel5.setText("Departamento:");

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 14));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButton1.setText("Adicionar");
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
        jButton3.setText("Calcular Folha Total");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tipo", "Nome", "Salário", "Departamento"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel6.setText("Aumento % Gerentes:");

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jTextField3.setText("10");

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
                            .addComponent(jComboBox1, 0, 120, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        String nome = jTextField1.getText().trim();
        String salarioStr = jTextField2.getText().trim();
        String tipo = (String) jComboBox1.getSelectedItem();
        String departamento = (String) jComboBox2.getSelectedItem();
        String aumentoStr = jTextField3.getText().trim();
        
        // Validações
        if (nome.isEmpty() || salarioStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha nome e salário!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            double salario = Double.parseDouble(salarioStr);
            if (salario <= 0) {
                JOptionPane.showMessageDialog(this, "Salário deve ser positivo!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            Funcionario funcionario;
            String detalhes = "";
            
            if ("Gerente".equals(tipo)) {
                if (departamento == null || departamento.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Gerente precisa de departamento!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                funcionario = new Gerente(nome, salario, departamento);
                detalhes = "Departamento: " + departamento;
                
                // Aplica aumento se especificado
                if (!aumentoStr.isEmpty()) {
                    try {
                        double percentual = Double.parseDouble(aumentoStr);
                        double salarioAntigo = salario;
                        ((Gerente) funcionario).aumentarSalario(percentual);
                        double novoSalario = funcionario.getSalario();
                        detalhes += String.format("\nAumento: %.1f%% (%.2f MT → %.2f MT)", 
                            percentual, salarioAntigo, novoSalario);
                    } catch (NumberFormatException e) {
                        // Ignora se não for número válido
                    }
                }
            } else {
                funcionario = new Funcionario(nome, salario);
                detalhes = "Funcionário Geral";
            }
            
            funcionarioModel.adicionarFuncionario(funcionario);
            
            // Limpar campos
            jTextField1.setText("");
            jTextField2.setText("");
            if ("Funcionário".equals(tipo)) {
                jComboBox2.setSelectedIndex(0); // Reseta departamento
            }
            
            JOptionPane.showMessageDialog(this, 
                tipo + " adicionado com sucesso!\n" +
                "Nome: " + nome + "\n" +
                "Salário: " + String.format("%,.2f MT", funcionario.getSalario()) + "\n" +
                detalhes,
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Salário deve ser um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            if (funcionarioModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Não há dados para salvar!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            funcionarioModel.salvarFuncionarios("funcionarios.dat");
            
            JOptionPane.showMessageDialog(this, 
                "Dados salvos com sucesso!\n" +
                "Total: " + funcionarioModel.getRowCount() + " funcionários\n" +
                "Arquivo: funcionarios.dat",
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (funcionarioModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Não há funcionários cadastrados!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // ⭐⭐ RECURSIVIDADE - Calcula folha total ⭐⭐
        double folhaTotal = funcionarioModel.calcularFolhaTotalRecursivamente();
        
        JOptionPane.showMessageDialog(this, 
            "FOLHA SALARIAL TOTAL\n" +
            "Total de funcionários: " + funcionarioModel.getRowCount() + "\n" +
            "Valor total: " + String.format("%,.2f MT", folhaTotal) + "\n" +
            "\n⭐ Cálculo feito com RECURSIVIDADE",
            "Folha Salarial", JOptionPane.INFORMATION_MESSAGE);
    }                                        

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;

    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame("Funcionários e Gerentes - Exercício 4");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Exercicio4());
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}