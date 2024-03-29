/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JInternalFrame;

/**
 *
 * @author JON
 */
public class TelaSecretaria extends javax.swing.JInternalFrame {

    public TelaSecretaria() {
        initComponents();
        setLocation(380, 180);

    }

    TelaCadastraTurmas tat = new TelaCadastraTurmas();
    TelaCadastraAluno tca = new TelaCadastraAluno();
    TelaCadastraCurso tcc = new TelaCadastraCurso();
    TelaCadastraDisciplina tcd = new TelaCadastraDisciplina();
    TelaMatriculaAluno tma = new TelaMatriculaAluno();
    TelaEmitiDiario tem = new TelaEmitiDiario();
    TelaEmitirHistorico teh = new TelaEmitirHistorico();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpTelaSecretaria = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuAluno = new javax.swing.JMenuItem();
        menuCurso = new javax.swing.JMenuItem();
        menuDisciplina = new javax.swing.JMenuItem();
        menuTurma = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        menuMatricAluno = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        menuDiario = new javax.swing.JMenuItem();
        menuHistorico = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Secretaria");

        javax.swing.GroupLayout jdpTelaSecretariaLayout = new javax.swing.GroupLayout(jdpTelaSecretaria);
        jdpTelaSecretaria.setLayout(jdpTelaSecretariaLayout);
        jdpTelaSecretariaLayout.setHorizontalGroup(
            jdpTelaSecretariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jdpTelaSecretariaLayout.setVerticalGroup(
            jdpTelaSecretariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenuBar1.setForeground(new java.awt.Color(0, 102, 102));
        jMenuBar1.setOpaque(false);

        jMenu1.setText("Cadastro");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        menuAluno.setText("Aluno");
        menuAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAlunoActionPerformed(evt);
            }
        });
        jMenu1.add(menuAluno);

        menuCurso.setText("Curso");
        menuCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCursoActionPerformed(evt);
            }
        });
        jMenu1.add(menuCurso);

        menuDisciplina.setText("Disciplinas");
        menuDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDisciplinaActionPerformed(evt);
            }
        });
        jMenu1.add(menuDisciplina);

        menuTurma.setText("Turma");
        menuTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTurmaActionPerformed(evt);
            }
        });
        jMenu1.add(menuTurma);
        jMenu1.add(jSeparator1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Matricula");

        menuMatricAluno.setText("Aluno");
        menuMatricAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMatricAlunoActionPerformed(evt);
            }
        });
        jMenu2.add(menuMatricAluno);
        jMenu2.add(jSeparator2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Emissão");

        menuDiario.setText("Diário");
        menuDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDiarioActionPerformed(evt);
            }
        });
        jMenu3.add(menuDiario);

        menuHistorico.setText("Histórico Escolar");
        menuHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHistoricoActionPerformed(evt);
            }
        });
        jMenu3.add(menuHistorico);
        jMenu3.add(jSeparator3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpTelaSecretaria)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpTelaSecretaria)
        );

        setBounds(0, 10, 1170, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void menuDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDiarioActionPerformed
        if (tem.isVisible()) {
            tem.toFront();
            tem.requestFocus();

        } else {
            jdpTelaSecretaria.add(tem);
            tem.setVisible(true);
        }
    }//GEN-LAST:event_menuDiarioActionPerformed

    private void menuCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCursoActionPerformed
        if (tcc.isVisible()) {
            tcc.toFront();
            tcc.requestFocus();

        } else {
            jdpTelaSecretaria.add(tcc);
            tcc.setVisible(true);
        }

    }//GEN-LAST:event_menuCursoActionPerformed

    private void menuDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDisciplinaActionPerformed
        if (tcd.isVisible()) {
            tcd.toFront();
            tcd.requestFocus();

        } else {
            jdpTelaSecretaria.add(tcd);
            tcd.setVisible(true);
        }
    }//GEN-LAST:event_menuDisciplinaActionPerformed

    private void menuAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAlunoActionPerformed
        if (tca.isVisible()) {
            tca.toFront();
            tca.requestFocus();

        } else {
            jdpTelaSecretaria.add(tca);
            tca.setVisible(true);
        }
    }//GEN-LAST:event_menuAlunoActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void menuTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTurmaActionPerformed
        if (tat.isVisible()) {
            tca.toFront();
            tca.requestFocus();
        } else {
            jdpTelaSecretaria.add(tat);
            tat.setVisible(true);
        }
    }//GEN-LAST:event_menuTurmaActionPerformed

    private void menuMatricAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMatricAlunoActionPerformed
        if (tma.isVisible()) {
            tma.toFront();
            tma.requestFocus();
        } else {
            jdpTelaSecretaria.add(tma);
            tma.setVisible(true);
        }
    }//GEN-LAST:event_menuMatricAlunoActionPerformed

    private void menuHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHistoricoActionPerformed
        if (teh.isVisible()) {
            teh.toFront();
            teh.requestFocus();

        } else {
            jdpTelaSecretaria.add(teh);
            teh.setVisible(true);
        }
    }//GEN-LAST:event_menuHistoricoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JDesktopPane jdpTelaSecretaria;
    private javax.swing.JMenuItem menuAluno;
    private javax.swing.JMenuItem menuCurso;
    private javax.swing.JMenuItem menuDiario;
    private javax.swing.JMenuItem menuDisciplina;
    private javax.swing.JMenuItem menuHistorico;
    private javax.swing.JMenuItem menuMatricAluno;
    private javax.swing.JMenuItem menuTurma;
    // End of variables declaration//GEN-END:variables
}
