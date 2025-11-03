package View;

import model.Pagavel;
import model.FuncionarioAssalariado;
import model.Freelancer;
import model.PagamentoModel;
import javax.swing.JOptionPane;

public class Exercicio5 extends javax.swing.JPanel {
    private PagamentoModel pagamentoModel;

    public Exercicio5() {
        initComponents();
        pagamentoModel = new PagamentoModel();
        jTable1.setModel(pagamentoModel);
        configurarComboBox();
        pagamentoModel.carregarPagaveis("pagamentos.dat");
    }
    
    private void configurarComboBox() {
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[] { "Funcionário Assalariado", "Freelancer" }));
        
        // Listener para mostrar/esconder campos específicos
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarVisibilidadeCampos();
            }
        });
        
        // Configurar estado inicial
        atualizarVisibilidadeCampos();
    }
    
    private void atualizarVisibilidadeCampos() {
        String tipo = (String) jComboBox1.getSelectedItem();
        boolean ehFreelancer = "Freelancer".equals(tipo);
        
        // Mostrar/Esconder campos específicos do Freelancer
        jLabel5.setVisible(ehFreelancer);
        jSpinner1.setVisible(ehFreelancer);
        
        // Atualizar labels dos campos comuns
        if (ehFreelancer) {
            jLabel3.setText("Valor por Hora:");
            jLabel4.setText("Horas Trabalhadas:");
        } else {
            jLabel3.setText("Salário Mensal:");
            jLabel4.setText("Salário Fixo");
            jLabel4.setVisible(false); // Esconde este label para funcionário
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
        jLabel5 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
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
        jLabel1.setText("Sistema de Pagamentos");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel2.setText("Nome:");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel3.setText("Salário Mensal:");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel4.setText("Salário Fixo");
        jLabel4.setVisible(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel5.setText("Horas Trabalhadas:");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 500, 1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel6.setText("Tipo:");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14));

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
        jButton3.setText("Calcular Total");
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
                "Tipo", "Nome", "Detalhes", "Pagamento", "Tipo Pagamento"
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
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jLabel5)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
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
        String valorStr = jTextField2.getText().trim();
        String tipo = (String) jComboBox1.getSelectedItem();
        
        // Validações básicas
        if (nome.isEmpty() || valorStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha nome e valor!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            Pagavel pagavel;
            String detalhes = "";
            
            if ("Freelancer".equals(tipo)) {
                // Validações para Freelancer
                int horas = (Integer) jSpinner1.getValue();
                
                if (horas <= 0) {
                    JOptionPane.showMessageDialog(this, "Horas devem ser positivas!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                double valorHora = Double.parseDouble(valorStr);
                pagavel = new Freelancer(nome, valorHora, horas);
                detalhes = String.format("%,d horas × %,.2f MT/hora", horas, valorHora);
                
            } else {
                // Funcionário Assalariado
                double salario = Double.parseDouble(valorStr);
                if (salario <= 0) {
                    JOptionPane.showMessageDialog(this, "Salário deve ser positivo!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                pagavel = new FuncionarioAssalariado(nome, salario);
                detalhes = String.format("Salário fixo: %,.2f MT", salario);
            }
            
            pagamentoModel.adicionarPagavel(pagavel);
            
            // Limpar campos
            jTextField1.setText("");
            jTextField2.setText("");
            jSpinner1.setValue(0);
            
            double pagamento = pagavel.calcularPagamento();
            
            JOptionPane.showMessageDialog(this, 
                tipo + " adicionado com sucesso!\n" +
                "Nome: " + nome + "\n" +
                detalhes + "\n" +
                "Pagamento: " + String.format("%,.2f MT", pagamento) + "\n" +
                "Tipo: " + pagavel.getTipoPagamento(),
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valores devem ser números válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            if (pagamentoModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Não há dados para salvar!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            pagamentoModel.salvarPagaveis("pagamentos.dat");
            
            JOptionPane.showMessageDialog(this, 
                "Dados salvos com sucesso!\n" +
                "Total: " + pagamentoModel.getRowCount() + " registros\n" +
                "Arquivo: pagamentos.dat",
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (pagamentoModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Não há pagamentos cadastrados!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // ⭐⭐ POLIMORFISMO - Calcula total de pagamentos ⭐⭐
        double totalPagamentos = pagamentoModel.calcularTotalPagamentos();
        int totalFuncionarios = pagamentoModel.getTotalFuncionariosAssalariados();
        int totalFreelancers = pagamentoModel.getTotalFreelancers();
        
        JOptionPane.showMessageDialog(this, 
            "TOTAL DE PAGAMENTOS\n" +
            "Funcionários Assalariados: " + totalFuncionarios + "\n" +
            "Freelancers: " + totalFreelancers + "\n" +
            "Total Geral: " + String.format("%,.2f MT", totalPagamentos) + "\n" +
            "\n⭐ Cálculo feito com POLIMORFISMO",
            "Total de Pagamentos", JOptionPane.INFORMATION_MESSAGE);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;

    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame("Sistema de Pagamentos - Exercício 5");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Exercicio5());
        frame.setSize(800, 550);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}