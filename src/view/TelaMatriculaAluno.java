/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Curso;
import model.Disciplina;
import model.Matricula;
import model.Pessoa;
import model.Turma;
import util.OrdenacaoBolha;

/**
 *
 * @author JON
 */
public class TelaMatriculaAluno extends javax.swing.JInternalFrame {
 
    public TelaMatriculaAluno() {
        initComponents();
        limparTela();
        preencheCombo();
        
    }
    
    public void limparTela (){
        txtMatricula.setText("");
        txtAluno.setText("");
        cmbCurso.removeAllItems();
        cmbSituacao.removeAllItems();
        cmbTurma.removeAllItems();
        cmbDisciplina.removeAllItems();
        buscaTurma("");
       
    }
    
    public void preencheCombo (){
        cmbSituacao.removeAllItems();
        cmbSituacao.addItem(" - - Selecione um item - - ");
        cmbSituacao.addItem("Matriculado");
        cmbSituacao.addItem("Trancado");
        cmbSituacao.addItem("Formado");
        cmbSituacao.addItem("Evadido");
    }
    
      
    public String buscaAluno(String nome, String iden){
       String sql = "SELECT * FROM pessoa WHERE pes_funcao = 'Aluno'";
            ArrayList<Pessoa> pessoa = Pessoa.listarPessoas(sql);
                        
            if (pessoa == null) {
                return null;
            }

            System.out.println();
            if (pessoa.isEmpty()) {
                System.out.println("Nenhuma pessoa cadastrada");
                return null;
            }
            String matricula = null;
            
            // percorre lista e mostra todas as contas
            for (Pessoa p : pessoa) {

                
                if(p.getPes_nome().equals(nome)){
                    matricula = p.getPes_iden();
                }
                if(p.getPes_iden().equals(iden)){
                    matricula = p.getPes_nome();
                }
            }
       
        return matricula; 
    }
     public int buscaCurso(String nome, int codigo){
     String sql = "SELECT * FROM curso";
            ArrayList<Curso> curso = Curso.ListarCursos(sql);
                        
            if (curso == null) {
                return 0;
            }

            System.out.println();
            if (curso.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhuma curso cadastrado");
                return 0;
            }
            int iden = 0;
            //cmbCurso.addItem("- - Selecione um curso - -");
            // percorre lista e mostra todas os cursos
            for (Curso c : curso) {
                
                cmbCurso.addItem(c.getCurs_descricao());
                if (c.getCurs_iden() == codigo){
                    cmbCurso.removeAllItems();
                    cmbCurso.addItem(c.getCurs_descricao());
                    return 0;
                }
                if(c.getCurs_descricao().equals(nome)){
                    cmbCurso.removeAllItems();
                    cmbCurso.addItem(String.valueOf(c.getCurs_iden()));
                             return 0;      
                }
            }
        return iden;
    }
     
     
     public int buscaTurma(String nome){
     String sql = "SELECT * FROM turma";
            ArrayList<Turma> turma = Turma.ListarTurma(sql);
                        
            if (turma == null) {
                return 0;
            }

            System.out.println();
            if (turma.isEmpty()) {
                System.out.println("Nenhuma turma cadastrada");
                return 0;
            }
           int iden = 0;
            cmbTurma.addItem("- -");
            // percorre lista e mostra todas os cursos
            for (Turma t : turma) {
                cmbTurma.addItem(String.valueOf(t.getTurm_iden()));
                
                
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
            
            //cmbDisciplina.addItem("- - Selecione um iten - -");
            // percorre lista e mostra todas os cursos
            for (Disciplina d : disc) {

                cmbDisciplina.addItem(d.getDisc_descricao());
                if(d.getDisc_descricao().equals(nome)){
                    iden = d.getDisc_curs_iden();
                    
                }
                if(d.getDisc_iden() == id){
                    cmbDisciplina.removeAllItems();
                    cmbDisciplina.addItem(d.getDisc_descricao());
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbTurma = new javax.swing.JComboBox<>();
        btnConsultar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbSituacao = new javax.swing.JComboBox<>();
        txtAluno = new javax.swing.JTextField();
        cmbCurso = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbDisciplina = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnMatricular = new javax.swing.JButton();
        btnAltera = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMatricula = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Matricular Aluno");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Matrícula");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Aluno");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Turma");

        cmbTurma.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbTurmaMouseClicked(evt);
            }
        });

        btnConsultar.setBackground(new java.awt.Color(153, 153, 153));
        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/busca.png"))); // NOI18N
        btnConsultar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), java.awt.Color.black, java.awt.Color.darkGray));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Situação");

        cmbSituacao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbSituacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbSituacaoMouseClicked(evt);
            }
        });
        cmbSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSituacaoActionPerformed(evt);
            }
        });

        txtAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAluno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAluno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));
        txtAluno.setEnabled(false);

        cmbCurso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbCursoMouseClicked(evt);
            }
        });
        cmbCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCursoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Curso");

        txtMatricula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtMatricula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtMatricula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtMatriculaMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Disciplina");

        cmbDisciplina.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbDisciplina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbDisciplinaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtAluno)
                            .addComponent(cmbCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cmbDisciplina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtAluno, txtMatricula});

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 3, 0, 10));

        btnMatricular.setBackground(new java.awt.Color(153, 153, 153));
        btnMatricular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMatricular.setText("Matricular");
        btnMatricular.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), java.awt.Color.black, java.awt.Color.darkGray));
        btnMatricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatricularActionPerformed(evt);
            }
        });
        jPanel2.add(btnMatricular);

        btnAltera.setBackground(new java.awt.Color(153, 153, 153));
        btnAltera.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAltera.setText("Alterar");
        btnAltera.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), java.awt.Color.black, java.awt.Color.darkGray));
        btnAltera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlteraActionPerformed(evt);
            }
        });
        jPanel2.add(btnAltera);

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

        tblMatricula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblMatricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MATRICULA", "ALUNO", "TURMA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMatriculaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMatricula);
        if (tblMatricula.getColumnModel().getColumnCount() > 0) {
            tblMatricula.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblMatricula.getColumnModel().getColumn(1).setPreferredWidth(140);
            tblMatricula.getColumnModel().getColumn(2).setPreferredWidth(10);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(380, 6, 465, 583);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblMatricula.getModel();
        
        int contlin = dtm.getRowCount();
        for (int i = 0; i < contlin; i++) {
            dtm.removeRow(0);
        }
        
        String sql = "";
        if (txtMatricula.getText().equals("   .   .   -  ")) {
            
            sql = "SELECT * FROM matricula";
            ArrayList<Matricula> matric = Matricula.ListaMatricula(sql);
            
            if (matric == null) {
                return;
            }

            System.out.println();
            if (matric.isEmpty()) {
                System.out.println(txtMatricula.getText() + ".");
                JOptionPane.showMessageDialog(null, "Aluno não está matriculado");

                return;
            }

            // percorre lista e mostra todas as contas
            //JOptionPane.showMessageDialog(null, "Carregando turma cadastradas");
            for (Matricula m : matric) {

                String dados[] = new String[4];
                dados[0] = String.valueOf(m.getMatr_pes_iden());
                dados[1] = buscaAluno("", m.getMatr_pes_iden());
                dados[2] = String.valueOf(m.getMat_turm_iden());
                              
                dtm.addRow(dados);

            }
        } else{
            
            sql = "SELECT * FROM matricula WHERE matr_pes_iden = '" + txtMatricula.getText() + "'";
            ArrayList<Matricula> matric = Matricula.ListaMatricula(sql);
            
            if (matric == null) {
                return;
            }

            System.out.println();
            if (matric.isEmpty()) {
                System.out.println(txtMatricula.getText() + ".");
                JOptionPane.showMessageDialog(null, "Matricula não encontrada");

                return;
            }

            // percorre lista e mostra todas as contas
            //JOptionPane.showMessageDialog(null, "Carregando turma cadastradas");
            for (Matricula m : matric) {
                txtMatricula.setText(m.getMatr_pes_iden());
                txtAluno.setText(buscaAluno("", m.getMatr_pes_iden()));
                cmbTurma.removeAllItems();
                cmbTurma.addItem(String.valueOf(m.getMat_turm_iden()));
                buscaDisciplina("", Integer.parseInt((String) cmbTurma.getSelectedItem()));
                cmbCurso.removeAllItems();
                buscaCurso("",buscaDisciplina((String) cmbDisciplina.getSelectedItem(), 0));
                cmbSituacao.removeAllItems();
                cmbSituacao.addItem(m.getSituacao());
                
               
            }
       
        }
        
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnAlteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlteraActionPerformed
      String matr_pes_iden = txtMatricula.getText();
        int turma = Integer.parseInt((String) cmbTurma.getSelectedItem());
        buscaCurso((String) cmbCurso.getSelectedItem(), 0);
        int curso = Integer.parseInt((String) cmbCurso.getSelectedItem());
        String situacao = (String) cmbSituacao.getSelectedItem();
        
        try {
            if (Matricula.AlterarMatricula(matr_pes_iden, turma, curso, situacao)) {
                
                JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso");
                limparTela();
            } else {
                JOptionPane.showMessageDialog(null, "Erro no cadastro");
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaMatriculaAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlteraActionPerformed

    private void cmbCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCursoActionPerformed
        
    }//GEN-LAST:event_cmbCursoActionPerformed

    private void cmbSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSituacaoActionPerformed
       
    }//GEN-LAST:event_cmbSituacaoActionPerformed

    private void tblMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMatriculaMouseClicked
        String sql = "";

        sql = "SELECT * FROM matricula";
            ArrayList<Matricula> matric = Matricula.ListaMatricula(sql);
            
            if (matric == null) {
                return;
            }

            System.out.println();
            if (matric.isEmpty()) {
                System.out.println(txtMatricula.getText() + ".");
                JOptionPane.showMessageDialog(null, "Matricula não encontrada");

                return;
            }
            
        int linhaSel = tblMatricula.getSelectedRow();
        cmbCurso.removeAllItems();
        cmbTurma.removeAllItems();
        cmbSituacao.removeAllItems();
        
        // percorre lista e mostra todas as matriculas
        for (Matricula m : matric) {
            if (tblMatricula.getValueAt(linhaSel, 0).equals(m.getMatr_pes_iden()) && tblMatricula.getValueAt(linhaSel, 2).equals(String.valueOf(m.getMat_turm_iden()))){
                
                txtMatricula.setText(m.getMatr_pes_iden());
                txtAluno.setText(buscaAluno("", m.getMatr_pes_iden()));
                cmbTurma.addItem(String.valueOf(m.getMat_turm_iden()));
                cmbCurso.removeAllItems();
                buscaCurso("", m.getMat_curso_iden());
                cmbDisciplina.removeAllItems();
                buscaDisciplina("", Integer.parseInt((String) cmbTurma.getSelectedItem()));
                cmbSituacao.removeAllItems();
                cmbSituacao.addItem(m.getSituacao());
            }
            }
    }//GEN-LAST:event_tblMatriculaMouseClicked

    private void btnMatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatricularActionPerformed
        String matr_pes_iden = txtMatricula.getText();
        int turma = Integer.parseInt((String) cmbTurma.getSelectedItem());
        buscaCurso((String) cmbCurso.getSelectedItem(), 0);
        int curso = Integer.parseInt((String) cmbCurso.getSelectedItem());
        String situacao = (String) cmbSituacao.getSelectedItem();

        try {
            if (Matricula.CadastrarMatricula(matr_pes_iden, turma, curso, situacao)) {
                
                JOptionPane.showMessageDialog(null, "Matricula realizada com sucesso");
                limparTela();
                
            } else {
                JOptionPane.showMessageDialog(null, "Erro no cadastro");
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaLancarAvaliacoes.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
    }//GEN-LAST:event_btnMatricularActionPerformed

    private void txtMatriculaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMatriculaMouseExited
        txtAluno.setText(buscaAluno("", txtMatricula.getText()));
    }//GEN-LAST:event_txtMatriculaMouseExited

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparTela();
       preencheCombo();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void cmbDisciplinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbDisciplinaMouseClicked
        buscaDisciplina("", Integer.parseInt((String) cmbTurma.getSelectedItem()));
    }//GEN-LAST:event_cmbDisciplinaMouseClicked

    private void cmbCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbCursoMouseClicked
        cmbCurso.removeAllItems();
        buscaCurso("",buscaDisciplina((String) cmbDisciplina.getSelectedItem(), 0));
        
    }//GEN-LAST:event_cmbCursoMouseClicked

    private void cmbTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbTurmaMouseClicked
        cmbTurma.removeAllItems();
        buscaTurma("");
    }//GEN-LAST:event_cmbTurmaMouseClicked

    private void cmbSituacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSituacaoMouseClicked
        preencheCombo();
    }//GEN-LAST:event_cmbSituacaoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltera;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnMatricular;
    private javax.swing.JComboBox<String> cmbCurso;
    private javax.swing.JComboBox<String> cmbDisciplina;
    private javax.swing.JComboBox<String> cmbSituacao;
    private javax.swing.JComboBox<String> cmbTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMatricula;
    private javax.swing.JTextField txtAluno;
    private javax.swing.JFormattedTextField txtMatricula;
    // End of variables declaration//GEN-END:variables
}
