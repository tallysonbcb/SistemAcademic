/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Curso;
import model.Pessoa;

/**
 *
 * @author JON
 */
public class TelaEmitirHistorico extends javax.swing.JInternalFrame {

    public TelaEmitirHistorico() {
        initComponents();
        setLocation(300, 80);
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
       
    public String buscaCurso(String nome) {
        String sql = "select * from matricula m, curso c, pessoa p where\n"
                + "p.pes_iden = m.matr_pes_iden and\n"
                + "m.matr_curs_iden = c.curs_iden and\n"
                + "p.pes_iden = '" + nome + "'";
        ArrayList<Curso> curso = Curso.ListarCursos(sql);
                        
            if (curso == null) {
                return "";
            }
            String curso_desc = null;
            System.out.println();
            if (curso.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum curso cadastrado");
                return "";
            }
            
            // percorre lista e mostra todas os cursos
            for (Curso c : curso) {
                curso_desc = c.getCurs_descricao();
                }
            
        return curso_desc;
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
        btnEmitir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAluno = new javax.swing.JTextField();
        txtMatricula = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtHistorico = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Emitir Histórico");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setOpaque(false);

        btnEmitir.setBackground(new java.awt.Color(153, 153, 153));
        btnEmitir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEmitir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/busca.png"))); // NOI18N
        btnEmitir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), java.awt.Color.black, java.awt.Color.darkGray));
        btnEmitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Matricula");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Aluno");

        txtAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAluno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAluno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));

        txtMatricula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtMatricula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtMatricula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtHistorico.setColumns(20);
        txtHistorico.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtHistorico.setForeground(new java.awt.Color(0, 0, 102));
        txtHistorico.setRows(5);
        jScrollPane2.setViewportView(txtHistorico);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 276, Short.MAX_VALUE))
                            .addComponent(txtAluno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEmitir, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnEmitir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtAluno, txtMatricula});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(380, 10, 618, 444);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirActionPerformed
        
        txtAluno.setText(buscaPessoa("", txtMatricula.getText()));
        String desc = buscaCurso(txtMatricula.getText());
        
        String saida = "Aluno: " + txtAluno.getText() + " - Matricula: " + txtMatricula.getText() + "\n";
                saida += "Curso: " + desc +" \n";
                saida += "Disciplina: \n";
                saida += " => Algoritmo - Nota 1 = 10.00, Nota 2 = 10.00, Nota Final = 8.00\n";
                saida += "                Frequencia = 75 %, Media = 8.00, Aprovado\n";
                
        txtHistorico.setText(saida);
        
    }//GEN-LAST:event_btnEmitirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmitir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtAluno;
    private javax.swing.JTextArea txtHistorico;
    private javax.swing.JFormattedTextField txtMatricula;
    // End of variables declaration//GEN-END:variables
}
