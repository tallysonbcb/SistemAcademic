/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Avaliacao;
import model.Diario;
import model.Disciplina;
import model.Pessoa;

/**
 *
 * @author JON
 */
public class TelaLancarAvaliacoes extends javax.swing.JInternalFrame {

    public TelaLancarAvaliacoes() {
        initComponents();
      
        

    }

    public void limparTela() {
      
        txtMatricula.setText("");
        txtNome.setText("");
        txtFrequencia.setText("");
        txtNota1.setText("");
        txtNota2.setText("");
        txtMedia.setText("");
        txtNotaFinal.setText("");
        txtSituacao.setText("");
        cmbDisciplina.removeAllItems();
       txtMatricula.setEditable(true);
        txtNome.setEditable(true);
        cmbDisciplina.setEditable(true);
    }

    public int buscaDisciplina(String matric, String desc) {
        String sql = "select * from matricula m, turma t, disciplina d, pessoa p WHERE p.pes_iden = m.matr_pes_iden AND m.matr_turm_iden = t.turm_iden AND t.turm_disc_iden = d.disc_iden AND p.pes_iden = '" + matric + "'";
        ArrayList<Disciplina> disc = Disciplina.ListarDisciplinas(sql);

        if (disc == null) {
            return 0;
        }

        System.out.println();
        if (disc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aluno não matriculado");
            System.out.println();
            return 0;
        }
        int iden = 0;
        
        // percorre lista e mostra todas os cursos
        for (Disciplina d : disc) {
            cmbDisciplina.addItem(d.getDisc_descricao());
            if(d.getDisc_descricao().equals(desc)){
            iden = d.getDisc_iden();
            }
        }
        return iden;
    }

       public String buscaPessoa(String nome, String iden){
       String sql = "SELECT * FROM pessoa";
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
                    return p.getPes_nome();
                }
            }
       
        return matricula; 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cmbDisciplina = new javax.swing.JComboBox<>();
        txtMatricula = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNota1 = new javax.swing.JTextField();
        txtNota2 = new javax.swing.JTextField();
        txtNotaFinal = new javax.swing.JTextField();
        txtMedia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFrequencia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSituacao = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnLancar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Lançar Avaliações");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Matric. Aluno");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Aluno");

        txtNome.setEditable(false);
        txtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));

        btnConsultar.setBackground(new java.awt.Color(153, 153, 153));
        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/busca.png"))); // NOI18N
        btnConsultar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), java.awt.Color.black, java.awt.Color.darkGray));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Disciplina");

        cmbDisciplina.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbDisciplina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbDisciplinaMouseClicked(evt);
            }
        });

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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calcular Situação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12))); // NOI18N

        jPanel3.setLayout(new java.awt.GridLayout(2, 4));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nota 1");
        jPanel3.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Nota 2");
        jPanel3.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Nota Final");
        jPanel3.add(jLabel6);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Media");
        jPanel3.add(jLabel10);

        txtNota1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNota1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNota1.setText("0,00");
        txtNota1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));
        txtNota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNota1ActionPerformed(evt);
            }
        });
        jPanel3.add(txtNota1);

        txtNota2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNota2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNota2.setText("0,00");
        txtNota2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));
        jPanel3.add(txtNota2);

        txtNotaFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNotaFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNotaFinal.setText("0,00");
        txtNotaFinal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));
        jPanel3.add(txtNotaFinal);

        txtMedia.setEditable(false);
        txtMedia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMedia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMedia.setText("0,00");
        txtMedia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));
        jPanel3.add(txtMedia);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Frequência");

        txtFrequencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFrequencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFrequencia.setText("0,00");
        txtFrequencia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));
        txtFrequencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFrequenciaMouseClicked(evt);
            }
        });
        txtFrequencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFrequenciaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Situação");

        txtSituacao.setEditable(false);
        txtSituacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSituacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSituacao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));

        btnCalcular.setBackground(new java.awt.Color(153, 153, 153));
        btnCalcular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), java.awt.Color.black, java.awt.Color.darkGray));
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(txtFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSituacao))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                    .addGap(5, 5, 5)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSituacao, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(txtFrequencia))
                .addGap(18, 18, 18)
                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(119, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 179, Short.MAX_VALUE))
                            .addComponent(txtNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbDisciplina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtMatricula, txtNome});

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 1, 0, 10));

        btnLancar.setBackground(new java.awt.Color(153, 153, 153));
        btnLancar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLancar.setText("Lançar");
        btnLancar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), java.awt.Color.black, java.awt.Color.darkGray));
        btnLancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLancarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLancar);

        btnAlterar.setBackground(new java.awt.Color(153, 153, 153));
        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), java.awt.Color.black, java.awt.Color.darkGray));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        setBounds(370, 6, 475, 462);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        
        
        cmbDisciplina.removeAllItems();
        buscaDisciplina(txtMatricula.getText(),"");
        txtNome.setText(buscaPessoa("", txtMatricula.getText()));
        
        String sql = "SELECT * FROM avaliacao WHERE aval_alun_iden = '" + txtMatricula.getText() + "'";
        ArrayList<Avaliacao> aval = Avaliacao.ListarAvaliacao(sql);

        if (aval.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há avaliação para esta matrícula!!!");
        } else {
            
            // percorre lista e mostra todas as pessoas           
            for (Avaliacao a : aval) {
                txtNota1.setText(String.valueOf(a.getAval_nota1()));
                txtNota2.setText(String.valueOf(a.getAval_nota2()));
                txtNotaFinal.setText(String.valueOf(a.getAval_notafinal()));
                txtMedia.setText(String.valueOf(a.getAval_media()));
                txtFrequencia.setText(String.valueOf(a.getAval_frequencia()));
                txtSituacao.setText(a.getAval_situacao());
            }
        }
        
     
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void calcularMedia(String nota1, String nota2, String nota3, String frequencia) throws ParseException {
        double n1 = converte(nota1);
        double n2 = converte(nota2);
        double n3 = converte(nota3);
        double freq = converte(frequencia);
        
        if (freq >= 0.75) {
            if (n3 == 0) {
                double media = (n1 + n2) / 2;
                txtMedia.setText(String.format("%.2f",media));
                if (media >= 6.0) {
                    txtSituacao.setText("Aprovado");
                }
                if (media < 6.0) {
                    txtSituacao.setText("Realizar prova final");
                }
            } else if (n3 != 0) {
                if (freq >= 0.75) {
                    double media = (n1 + n2 + n3) / 3;
                    txtMedia.setText(String.format("%.2f",media));
                    if (media >= 5.0) {
                        txtSituacao.setText("Aprovado");
                    }
                    if (media <= 5.0) {
                        txtSituacao.setText("Reprovado por Média");
                    }
                }
            }
        } else {
            double media = (n1 + n2) / 2;
            txtMedia.setText(String.format("%.2f",media));
            txtSituacao.setText("Reprovado por falta");
        }
    }
    
    public double converte(String arg) throws ParseException{
		
		return Double.parseDouble(arg.replace(",", "."));
		
	}
    
    private void btnLancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLancarActionPerformed
                
        
        try {
            int aval_disc_iden = buscaDisciplina(txtMatricula.getText(), (String) cmbDisciplina.getSelectedItem());
            String aval_prof_iden = "104.326.426-41";
            String aval_alun_iden = txtMatricula.getText();
            double aval_frequencia = converte(txtFrequencia.getText());
            double aval_nota1 = converte(txtNota1.getText());
            double aval_nota2 = converte(txtNota2.getText());
            double aval_notafinal = converte(txtNotaFinal.getText());
            double aval_media = converte(txtMedia.getText());
            String aval_situacao = txtSituacao.getText();

            try {
                if (Avaliacao.cadastrarAvaliacao(aval_disc_iden, aval_prof_iden,
                        aval_alun_iden, aval_frequencia, aval_nota1, aval_nota2,
                        aval_notafinal, aval_media, aval_situacao)) {

                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
                    limparTela();

                } else {
                    JOptionPane.showMessageDialog(null, "Erro no cadastro");
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaLancarAvaliacoes.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            }

        } catch (ParseException ex) {
            Logger.getLogger(TelaLancarAvaliacoes.class.getName()).log(Level.SEVERE, null, ex);
        }

        

       


    }//GEN-LAST:event_btnLancarActionPerformed

    private void txtMatriculaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMatriculaMouseExited
        txtNome.setText(buscaPessoa("", txtMatricula.getText()));
        
    }//GEN-LAST:event_txtMatriculaMouseExited

    private void cmbDisciplinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbDisciplinaMouseClicked
        cmbDisciplina.removeAllItems();
        buscaDisciplina(txtMatricula.getText(), "");
    }//GEN-LAST:event_cmbDisciplinaMouseClicked

    private void txtNota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNota1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNota1ActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        try {
            calcularMedia(txtNota1.getText(), txtNota2.getText(), txtNotaFinal.getText(), txtFrequencia.getText());
        } catch (ParseException ex) {
            Logger.getLogger(TelaLancarAvaliacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            int aval_disc_iden = buscaDisciplina(txtMatricula.getText(),"");
            String aval_prof_iden = "104.326.426-41";
            String aval_alun_iden = txtMatricula.getText();
            double aval_frequencia = converte(txtFrequencia.getText());
            double aval_nota1 = converte(txtNota1.getText());
            double aval_nota2 = converte(txtNota2.getText());
            double aval_notafinal = converte(txtNotaFinal.getText());
            double aval_media = converte(txtMedia.getText());
            String aval_situacao = txtSituacao.getText();

                         
        if (Avaliacao.AlterarAvaliacao(aval_disc_iden, aval_prof_iden, aval_alun_iden, aval_frequencia, aval_nota1, aval_nota2, aval_notafinal, aval_media, aval_situacao)) {
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na alteração da disciplina");
        }
        } catch (Exception e) {
        }
       
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtFrequenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFrequenciaActionPerformed
      
    }//GEN-LAST:event_txtFrequenciaActionPerformed

    private void txtFrequenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFrequenciaMouseClicked
          String aluno = txtMatricula.getText();
        String descr = (String) cmbDisciplina.getSelectedItem();
        
        String sql = "SELECT * FROM diario d WHERE d.diar_pes_iden = '" + aluno + "' AND d.diar_disc_desc = '" + descr + "'";
         ArrayList<Diario> diario = Diario.ListarDiario(sql);

        if (diario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há diario para esta matrícula!!!");
        } else {
            double cont1 = 0;
            double cont2 = 0;
            // percorre lista e mostra todas as pessoas           
            for (Diario d : diario) {
                
                if(d.getDiar_presenca() == 1){
                    cont1 ++;
                }
                cont2 ++;
            }
            
            txtFrequencia.setText(String.format("%.2f",(cont1/cont2)));
        }
    }//GEN-LAST:event_txtFrequenciaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnLancar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> cmbDisciplina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtFrequencia;
    private javax.swing.JFormattedTextField txtMatricula;
    private javax.swing.JTextField txtMedia;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNota1;
    private javax.swing.JTextField txtNota2;
    private javax.swing.JTextField txtNotaFinal;
    private javax.swing.JTextField txtSituacao;
    // End of variables declaration//GEN-END:variables
}
