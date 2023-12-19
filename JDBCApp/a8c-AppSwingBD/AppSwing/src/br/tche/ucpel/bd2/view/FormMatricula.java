package br.tche.ucpel.bd2.view;

import br.tche.ucpel.bd2.bean.Aluno;
import br.tche.ucpel.bd2.dao.DepartamentoDAO;
import br.tche.ucpel.bd2.bean.Departamento;
import br.tche.ucpel.bd2.bean.Disciplina;
import br.tche.ucpel.bd2.bean.Matricula;
import br.tche.ucpel.bd2.dao.AlunoDAO;
import br.tche.ucpel.bd2.dao.DisciplinaDAO;
import br.tche.ucpel.bd2.dao.MatriculaDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Classe responsável pelo desenho da tela de cadastro do Departamento.
 * <br/>
 * São tratados eventos de lostFocus (perda do foco) no campo txtCodigo, os
 * eventos de acionamento de botões e o duplo click na tabela.
 *
 * @author mertins
 */
public class FormMatricula extends javax.swing.JInternalFrame {

    private JFrame mdi;

    /**
     * Creates new form FormDepartamento
     *
     * @param mdi MDI principal.
     */
    public FormMatricula(JFrame mdi) {
        this.mdi = mdi;
        initComponents();
        this.atualizaLista();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        txtCod = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMatricula = new javax.swing.JTable();
        btLimpar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Matricula");

        jLabel1.setText("Matricula do Aluno");

        jLabel2.setText("Codigo Disciplina");

        txtMatricula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMatriculaFocusLost(evt);
            }
        });
        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        tbMatricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Matricula", "Cod. Disciplina"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMatricula.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMatriculaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbMatricula);

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAtualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btLimpar)
                        .addGap(18, 18, 18)
                        .addComponent(btExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btLimpar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btExcluir)
                        .addComponent(btAtualizar))
                    .addComponent(btSalvar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
    try {
        MatriculaDAO matriculaDAO = new MatriculaDAO(MDISistema.getConexao());
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO(MDISistema.getConexao());
        AlunoDAO alunoDAO = new AlunoDAO(MDISistema.getConexao());

        Disciplina disciplina = disciplinaDAO.findById(intCampoTelas(this.txtCod.getText()));

        if (disciplina == null) {
            JOptionPane.showMessageDialog(this.mdi, "Disciplina não encontrada no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Sai do método se a disciplina não for encontrada
        }

        Aluno aluno = alunoDAO.findById(intCampoTelas(this.txtMatricula.getText()));

        if (aluno == null) {
            JOptionPane.showMessageDialog(this.mdi, "Aluno não encontrada no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Sai do método se a disciplina não for encontrada
        }

        Matricula matricula = new Matricula(disciplina, aluno);

        matriculaDAO.create(matricula);
        JOptionPane.showMessageDialog(this.mdi, "Registro Salvo");
        this.limpaTela();
        this.atualizaLista();
    } catch (SQLException ex) {//GEN-LAST:event_btSalvarActionPerformed
            JOptionPane.showMessageDialog(this.mdi, String.format("Erro ao gravar Matricula:%s", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FormMatricula.class.getName()).log(Level.WARNING, "Erro ao gravar Matricula", ex);
        }
    }

private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
    // this.atualizaLista();
}//GEN-LAST:event_btAtualizarActionPerformed

private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

    try {
        MatriculaDAO matriculaDAO = new MatriculaDAO(MDISistema.getConexao());
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO(MDISistema.getConexao());
        AlunoDAO alunoDAO = new AlunoDAO(MDISistema.getConexao());

        Disciplina disciplina = disciplinaDAO.findById(intCampoTelas(this.txtCod.getText()));

        if (disciplina == null) {
            JOptionPane.showMessageDialog(this.mdi, "Disciplina não encontrada no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Sai do método se a disciplina não for encontrada
        }

        Aluno aluno = alunoDAO.findById(intCampoTelas(this.txtMatricula.getText()));

        if (aluno == null) {
            JOptionPane.showMessageDialog(this.mdi, "Aluno não encontrada no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Sai do método se a disciplina não for encontrada
        }

        Matricula matricula = new Matricula(disciplina, aluno);

        matriculaDAO.delete(matricula);
        this.limpaTela();
        this.atualizaLista();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this.mdi, String.format("Erro ao excluir :%s", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(FormMatricula.class.getName()).log(Level.WARNING, "Erro ao excluir ", ex);
    }
    this.atualizaLista();
}//GEN-LAST:event_btExcluirActionPerformed

private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
    this.limpaTela();
}//GEN-LAST:event_btLimparActionPerformed

private void tbMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMatriculaMouseClicked
// TODO add your handling code here
    try {
        if (evt.getClickCount() > 1) {
            JTable obj = (JTable) evt.getComponent();
            int linha = obj.getSelectedRow();
            Integer codMatricula = (Integer) obj.getModel().getValueAt(linha, 0);
            Integer codDisciplina = (Integer) obj.getModel().getValueAt(linha, 1);

            AlunoDAO alunoDAO = new AlunoDAO(MDISistema.getConexao());
            DisciplinaDAO disciplinaDAO = new DisciplinaDAO(MDISistema.getConexao());

            Aluno aluno = alunoDAO.findById(codMatricula);
            Disciplina disciplina = disciplinaDAO.findById(codDisciplina);
            Matricula matricula = new Matricula(disciplina, aluno);
            this.preencheTela(matricula);
        }
    } catch (SQLException ex) {
        Logger.getLogger(FormMatricula.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_tbMatriculaMouseClicked

private void txtMatriculaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatriculaFocusLost
// TODO add your handling code here:
    /*  int cod = this.intCampoTelas(this.txtMatricula.getText());
    if (cod > 0) {
        Matricula matricula = new Matricula(cod);
        boolean ret = this.preencheTela(matricula);
        if (!ret) {
            JOptionPane.showMessageDialog(this.mdi, "Código não existe no sistema", "Aviso", JOptionPane.WARNING_MESSAGE);
            this.txtMatricula.requestFocusInWindow();
        }
    }*/
}//GEN-LAST:event_txtMatriculaFocusLost

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaActionPerformed

    /**
     * Método auxiliar para atualizar a JTable com os dados
     */
    private void atualizaLista() {
        try {
            MatriculaDAO matriculaDAO = new MatriculaDAO(MDISistema.getConexao());
            List<Matricula> lista = matriculaDAO.listaTodos();
            DefaultTableModel dtm = (DefaultTableModel) this.tbMatricula.getModel();
            dtm.setRowCount(0);
            for (Matricula matricula : lista) {
                int matriculaAluno = (matricula.getAluno() != null) ? matricula.getAluno().getMatricula() : 0;
                int codDisciplina = (matricula.getDisciplina() != null) ? matricula.getDisciplina().getCod() : 0;

                dtm.addRow(new Object[]{matriculaAluno, codDisciplina});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this.mdi, String.format("Erro ao ler a matricula:%s", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);
            Logger
                    .getLogger(FormMatricula.class
                            .getName()).log(Level.WARNING, "Erro", ex);
        }
    }

    /**
     * Método auxiliar para limpar os campos da tela.
     */
    private void limpaTela() {
        this.txtMatricula.setEnabled(true);
        this.txtMatricula.setText(null);
        this.txtCod.setText(null);
    }

    /**
     * Método auxiliar para converter valores String sem causar exceções.
     *
     * @param valor String contendo o valor a ser transformado para número
     * @return O valor convertido em inteiro ou zero em caso de algum problema
     */
    private int intCampoTelas(String valor) {
        int ret = 0;
        try {
            ret = Integer.parseInt(valor);
        } catch (NumberFormatException ex) {
        }
        return ret;
    }

    /**
     * Preenche os campos da tela com informações do departamento
     *
     * @param matricula Departamento que irá fornecer a informação para pesquisa
     * no SGBD e em seguida ir para a tela.
     */
    private boolean preencheTela(Matricula matricula) {
        boolean ret = false;
        try {
            MatriculaDAO matriculaDAO = new MatriculaDAO(MDISistema.getConexao());
            matricula = matriculaDAO.retrieve(matricula);
            if (matricula != null && matricula.getAluno().getMatricula() > 0) {
                this.txtMatricula.setText(Integer.toString(matricula.getAluno().getMatricula()));
                this.txtMatricula.setEnabled(false);
                this.txtCod.setText(Integer.toString(matricula.getDisciplina().getCod()));
                ret = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this.mdi, String.format("Não foi possível carregar Matricula: %s", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);
            Logger
                    .getLogger(FormMatricula.class
                            .getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbMatricula;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtMatricula;
    // End of variables declaration//GEN-END:variables
}
