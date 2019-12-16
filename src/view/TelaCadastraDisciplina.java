/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Curso;
import model.Disciplina;
import model.Pessoa;
import util.OrdenacaoBolha;

/**
 *
 * @author JON
 */
public class TelaCadastraDisciplina extends javax.swing.JInternalFrame {

    public TelaCadastraDisciplina() {
        initComponents();
        LimparTela();
        setLocation(300, 10);
        
    }
    
        public void LimparTela() {
        
        txtCodigo.setText("");
        txtDescricao.setText("");
        cmbCurso.removeAllItems();
        cmbProfessor.removeAllItems();
        txtCargaHoraria.setText("");
        txtEmenta.setText("");
        txtBibliografia.setText("");
        cmbPreRequesito.removeAllItems();
        DefaultTableModel dtm = (DefaultTableModel) tblDisciplina.getModel();
        int contlin = dtm.getRowCount();
        for (int i = 0; i < contlin; i++) {
            dtm.removeRow(0);
        }
        carregaCombo();
    }

    private void carregaCombo(){
        cmbCurso.removeAllItems();
        cmbPreRequesito.removeAllItems();
        cmbProfessor.removeAllItems();
        buscaCurso("", 0);
        buscaProfessor("", "");
        buscaDisciplina("", 0);
        
    }
    
    public String buscaProfessor(String nome, String iden){
       String sql = "SELECT * FROM pessoa WHERE pes_funcao = 'Professor'";
            ArrayList<Pessoa> pessoa = Pessoa.listarPessoas(sql);
            OrdenacaoBolha ob = new OrdenacaoBolha();
            ob.bolha(pessoa);
            
            if (pessoa == null) {
                return null;
            }

            System.out.println();
            if (pessoa.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada");
                return null;
            }
            String matricula = null;
            cmbProfessor.removeAllItems();
            cmbProfessor.addItem("- - Selecione um professor - -");
            // percorre lista e mostra todas as contas
            for (Pessoa p : pessoa) {

                cmbProfessor.addItem(p.getPes_nome());
                if(p.getPes_nome().equals(nome)){
                    matricula = p.getPes_iden();
                }
                if(p.getPes_iden().equals(iden)){
                    cmbProfessor.removeAllItems();
                    cmbProfessor.addItem(p.getPes_nome());
                    return "";
                }
            }
        System.out.println(matricula);
        return matricula; 
    }
    
    public int buscaCurso(String nome, int id){
     String sql = "SELECT * FROM curso";
            ArrayList<Curso> curso = Curso.ListarCursos(sql);
                        
            if (curso == null) {
                return 0;
            }

            System.out.println();
            if (curso.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum curso cadastrado");
                return 0;
            }
            int iden = 0;
            cmbCurso.addItem("- - Selecione um curso - -");
            // percorre lista e mostra todas os cursos
            for (Curso c : curso) {

                cmbCurso.addItem(c.getCurs_descricao());
                if(c.getCurs_descricao().equals(nome)){
                    iden = c.getCurs_iden();
                }
                if(c.getCurs_iden() == id){
                    cmbCurso.removeAllItems();
                    cmbCurso.addItem(c.getCurs_descricao());
                    return 0;
                }
            }
        return iden;
    }
    
     public int buscaDisciplina(String nome, int id){
     String sql = "SELECT * FROM disciplina";
            ArrayList<Disciplina> disc = Disciplina.ListarDisciplinas(sql);
                        
            if (disc == null) {
                return 0;
            }

            System.out.println();
            if (disc.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhuma disciplina cadastrada");
                return 0;
            }
            int iden = 0;
            
            cmbPreRequesito.addItem("- - Selecione um iten - -");
            // percorre lista e mostra todas os cursos
            for (Disciplina d : disc) {

                cmbPreRequesito.addItem(d.getDisc_descricao());
                if(d.getDisc_descricao().equals(nome)){
                    iden = d.getDisc_iden();
                }
                if(d.getDisc_iden() == id){
                    cmbPreRequesito.removeAllItems();
                    cmbPreRequesito.addItem(d.getDisc_descricao());
                    return 0;
                }
                
            }
        return iden;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCargaHoraria = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmenta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBibliografia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbPreRequesito = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbProfessor = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDisciplina = new javax.swing.JTable();
        btnConsulta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbCurso = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnCadastra = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastrar Disciplina");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Carga Horária");

        txtCargaHoraria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCargaHoraria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCargaHoraria.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Ementa");

        txtEmenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Bibliografia");

        txtBibliografia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBibliografia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBibliografia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Pré - Requisitos");

        cmbPreRequesito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbPreRequesito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbPreRequesitoMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Professor");

        cmbProfessor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbProfessorMouseClicked(evt);
            }
        });

        tblDisciplina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblDisciplina.setForeground(new java.awt.Color(51, 51, 0));
        tblDisciplina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRICAO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDisciplina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDisciplinaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDisciplina);
        if (tblDisciplina.getColumnModel().getColumnCount() > 0) {
            tblDisciplina.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblDisciplina.getColumnModel().getColumn(1).setPreferredWidth(180);
        }

        btnConsulta.setBackground(new java.awt.Color(153, 153, 153));
        btnConsulta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/busca.png"))); // NOI18N
        btnConsulta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), java.awt.Color.black, java.awt.Color.darkGray));
        btnConsulta.setOpaque(false);
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Codigo");

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Descrição");

        txtDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDescricao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescricao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Curso");

        cmbCurso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbCursoMouseClicked(evt);
            }
        });

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btnCadastra.setBackground(new java.awt.Color(153, 153, 153));
        btnCadastra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCadastra.setText("Cadastrar");
        btnCadastra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), java.awt.Color.black, java.awt.Color.darkGray));
        btnCadastra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraActionPerformed(evt);
            }
        });
        jPanel2.add(btnCadastra);

        btnAlterar.setBackground(new java.awt.Color(153, 153, 153));
        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), java.awt.Color.black, java.awt.Color.darkGray));
        btnAlterar.setOpaque(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAlterar);

        btnLimpar.setBackground(new java.awt.Color(153, 153, 153));
        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), java.awt.Color.black, java.awt.Color.darkGray));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(27, 27, 27)
                        .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmbPreRequesito, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBibliografia, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(txtCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtEmenta))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBibliografia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbPreRequesito, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(380, 10, 516, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraActionPerformed
        int iden = Integer.parseInt(txtCodigo.getText());
        String descricao = txtDescricao.getText();
        int curso = buscaCurso((String) cmbCurso.getSelectedItem(), 0);
        String professor = buscaProfessor((String) cmbProfessor.getSelectedItem(),"");
        int cargaHoraria = Integer.parseInt(txtCargaHoraria.getText());
        String ementa = txtEmenta.getText();
        String bibl = txtBibliografia.getText();
        int preReq = 0;
        if(cmbPreRequesito.getSelectedIndex() != 0){
           preReq = buscaDisciplina((String) cmbPreRequesito.getSelectedItem(), 0);  
        }
        if (Disciplina.CadastrarDisciplina(iden, curso, descricao, preReq, cargaHoraria, bibl, ementa, professor)) {
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro no cadastro");
        }
        LimparTela();
        
    }//GEN-LAST:event_btnCadastraActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
       int iden = Integer.parseInt(txtCodigo.getText());
        String descricao = txtDescricao.getText();
        int curso = buscaCurso((String) cmbCurso.getSelectedItem(), 0);
        String professor = buscaProfessor((String) cmbProfessor.getSelectedItem(),"");
        int cargaHoraria = Integer.parseInt(txtCargaHoraria.getText());
        String ementa = txtEmenta.getText();
        String bibl = txtBibliografia.getText();
        int preReq = buscaDisciplina((String) cmbPreRequesito.getSelectedItem(), 0);

                         
        if (Disciplina.AlterarDisciplina(iden, curso, descricao, preReq, cargaHoraria, bibl, ementa, professor)) {
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na alteração da disciplina");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void tblDisciplinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDisciplinaMouseClicked
       String sql = "";
        
            sql = "SELECT * FROM disciplina";
            ArrayList<Disciplina> disc = Disciplina.ListarDisciplinas(sql);

            if (disc == null) {
                return;
            }

            System.out.println();
            if (disc.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum curso cadastrado");
                return;
            }
            int linhaSel = tblDisciplina.getSelectedRow();
            cmbCurso.removeAllItems();
            cmbPreRequesito.removeAllItems();
            cmbProfessor.removeAllItems();
            String coordenador = null;
            // percorre lista e mostra todas os cursos
            for (Disciplina d : disc) {
                if(tblDisciplina.getValueAt(linhaSel, 0).equals(String.valueOf(d.getDisc_iden()))){
                txtCodigo.setText(String.valueOf(d.getDisc_iden()));
                txtDescricao.setText(d.getDisc_descricao());
                txtCargaHoraria.setText(String.valueOf(d.getDisc_cargaHoraria()));
                txtBibliografia.setText(d.getDisc_bibliografia());
                txtEmenta.setText(d.getDisc_ementa());
                buscaCurso("", d.getDisc_curs_iden());
                buscaProfessor("", d.getDisc_prof_iden());
                cmbPreRequesito.addItem("");

                }
            }
    }//GEN-LAST:event_tblDisciplinaMouseClicked

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
       
        DefaultTableModel dtm = (DefaultTableModel) tblDisciplina.getModel();
        String sql = "SELECT * FROM disciplina";
        if (txtCodigo.getText().equals("")) {
            
            ArrayList<Disciplina> disciplina = Disciplina.ListarDisciplinas(sql);
                        
            if (disciplina == null) {
                return;
            }

            System.out.println();
            if (disciplina.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhuma discilina cadastrado");
                return;
            }
           
            // percorre lista e mostra todas os cursos
            for (Disciplina d : disciplina) {

                String dados[] = new String[2];
                dados[0] = String.valueOf(d.getDisc_iden());
                dados[1] = d.getDisc_descricao();
                dtm.addRow(dados);
            }
        } else {
            sql = "SELECT * FROM disciplina WHERE disc_iden = " + txtCodigo.getText();
            ArrayList<Disciplina> disciplina = Disciplina.ListarDisciplinas(sql);
                        
            if (disciplina == null) {
                return;
            }
            cmbCurso.removeAllItems();
            cmbPreRequesito.removeAllItems();
            cmbProfessor.removeAllItems();
            System.out.println();
            if (disciplina.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum curso cadastrado");
                return;
            }
            
            // percorre lista e mostra todas as pessoas           
            for (Disciplina d : disciplina) {

            if (Integer.parseInt(txtCodigo.getText()) == d.getDisc_iden()) {

                txtCodigo.setText(String.valueOf(d.getDisc_iden()));
                txtDescricao.setText(d.getDisc_descricao());
                txtCargaHoraria.setText(String.valueOf(d.getDisc_cargaHoraria()));
                txtBibliografia.setText(d.getDisc_bibliografia());
                txtEmenta.setText(d.getDisc_ementa());
                cmbCurso.addItem(String.valueOf(buscaCurso("", d.getDisc_curs_iden())));
                cmbProfessor.addItem(buscaProfessor("", d.getDisc_prof_iden()));
                cmbPreRequesito.addItem("");

                System.out.println();
            
            }
        }
        }
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        LimparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void cmbCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbCursoMouseClicked
        buscaCurso("", 0);
    }//GEN-LAST:event_cmbCursoMouseClicked

    private void cmbProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbProfessorMouseClicked
        
        buscaProfessor("", "");
    }//GEN-LAST:event_cmbProfessorMouseClicked

    private void cmbPreRequesitoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbPreRequesitoMouseClicked
        cmbPreRequesito.removeAllItems();
        buscaDisciplina("", 0);
    }//GEN-LAST:event_cmbPreRequesitoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastra;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> cmbCurso;
    private javax.swing.JComboBox<String> cmbPreRequesito;
    private javax.swing.JComboBox<String> cmbProfessor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDisciplina;
    private javax.swing.JTextField txtBibliografia;
    private javax.swing.JTextField txtCargaHoraria;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtEmenta;
    // End of variables declaration//GEN-END:variables
}
