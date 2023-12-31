package br.tche.ucpel.bd2.view;

import br.tche.ucpel.bd2.dao.DepartamentoDAO;
import br.tche.ucpel.bd2.bean.Departamento;
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
 * @author  mertins
 */
public class FormDepartamento extends javax.swing.JInternalFrame {

    private JFrame mdi;

    /** 
     * Creates new form FormDepartamento 
     * @param mdi MDI principal.
     */
    public FormDepartamento(JFrame mdi) {
        this.mdi = mdi;
        initComponents();
        this.atualizaLista();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDepartamentos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtLocalizacao = new javax.swing.JTextField();
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
        setTitle("Cadastro de Departamento");

        jLabel1.setText("Código");

        jLabel2.setText("Descrição");

        txtCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoFocusLost(evt);
            }
        });
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
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

        tbDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Localização"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDepartamentos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDepartamentosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbDepartamentos);

        jLabel3.setText("Localização");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLocalizacao, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir))
                    .addComponent(btAtualizar))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btExcluir)
                            .addComponent(btSalvar)
                            .addComponent(btLimpar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAtualizar)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
    try {
        DepartamentoDAO deptDAO = new DepartamentoDAO(MDISistema.getConexao());
        int cod = this.intCampoTelas(this.txtCodigo.getText());
        if (cod > 0) {
            Departamento dept = new Departamento(cod, this.txtDescricao.getText(), this.txtLocalizacao.getText());
            deptDAO.update(dept);
        } else {
            Departamento dept = new Departamento(0, this.txtDescricao.getText(), this.txtLocalizacao.getText());
            deptDAO.create(dept);
            this.txtCodigo.setText(Integer.toString(dept.getCod()));
        }
        JOptionPane.showMessageDialog(this.mdi, "Registro Salvo");
        this.limpaTela();
        this.atualizaLista();
    } catch (SQLException ex) {//GEN-LAST:event_btSalvarActionPerformed
            JOptionPane.showMessageDialog(this.mdi, String.format("Erro ao gravar Departamento:%s", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FormDepartamento.class.getName()).log(Level.WARNING, "Erro ao gravar Departamento", ex);
        }
    }

private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
    this.atualizaLista();
}//GEN-LAST:event_btAtualizarActionPerformed

private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

    try {
        int cod = this.intCampoTelas(this.txtCodigo.getText());
        if (cod > 0) {
            Departamento dept = new Departamento(cod);
            DepartamentoDAO deptDAO = new DepartamentoDAO(MDISistema.getConexao());
            deptDAO.delete(dept);
            this.limpaTela();
            this.atualizaLista();
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this.mdi, String.format("Erro ao excluir Departamento:%s", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(FormDepartamento.class.getName()).log(Level.WARNING, "Erro ao excluir Departamento", ex);
    }
    this.atualizaLista();
}//GEN-LAST:event_btExcluirActionPerformed

private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
    this.limpaTela();
}//GEN-LAST:event_btLimparActionPerformed

private void tbDepartamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDepartamentosMouseClicked
// TODO add your handling code here:
    if (evt.getClickCount() > 1) {
        JTable obj = (JTable) evt.getComponent();
        int linha = obj.getSelectedRow();
        Integer cod = (Integer) obj.getModel().getValueAt(linha, 0);
        Departamento dept = new Departamento(cod);
        this.preencheTela(dept);
    }
}//GEN-LAST:event_tbDepartamentosMouseClicked

private void txtCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoFocusLost
// TODO add your handling code here:
    int cod = this.intCampoTelas(this.txtCodigo.getText());
    if (cod > 0) {
        Departamento dept = new Departamento(cod);
        boolean ret = this.preencheTela(dept);
        if (!ret) {
            JOptionPane.showMessageDialog(this.mdi, "Código do Departamento não existe no sistema", "Aviso", JOptionPane.WARNING_MESSAGE);
            this.txtCodigo.requestFocusInWindow();
        }
    }
}//GEN-LAST:event_txtCodigoFocusLost

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    /**
     * Método auxiliar para atualizar a JTable com os dados do departamento
     */
    private void atualizaLista() {
        try {
            DepartamentoDAO deptDAO = new DepartamentoDAO(MDISistema.getConexao());
            List<Departamento> lista = deptDAO.listaTodos();
            DefaultTableModel dtm = (DefaultTableModel) this.tbDepartamentos.getModel();
            dtm.setRowCount(0);
            for (Departamento dept : lista) {
                dtm.addRow(new Object[]{dept.getCod(), dept.getDescricao(), dept.getLocalizacao()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this.mdi, String.format("Erro ao ler os Departamentos:%s", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FormDepartamento.class.getName()).log(Level.WARNING, "Erro ao ler os Departamentos", ex);
        }
    }

    /**
     * Método auxiliar para limpar os campos da tela.
     */
    private void limpaTela() {
        this.txtCodigo.setEnabled(true);
        this.txtCodigo.setText(null);
        this.txtDescricao.setText(null);
        this.txtLocalizacao.setText(null);
    }

    /**
     * Método auxiliar para converter valores String sem causar exceções.
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
     * @param dept Departamento que irá fornecer a informação para pesquisa no SGBD e em seguida ir para a tela.
     */
    private boolean preencheTela(Departamento dept) {
        boolean ret = false;
        try {
            DepartamentoDAO deptDAO = new DepartamentoDAO(MDISistema.getConexao());
            dept = deptDAO.retrieve(dept);
            if (dept != null && dept.getCod() > 0) {
                this.txtCodigo.setText(Integer.toString(dept.getCod()));
                this.txtCodigo.setEnabled(false);
                this.txtDescricao.setText(dept.getDescricao());
                this.txtLocalizacao.setText(dept.getLocalizacao());
                ret = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this.mdi, String.format("Não foi possível carregar Departamento: %s", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FormDepartamento.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbDepartamentos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtLocalizacao;
    // End of variables declaration//GEN-END:variables
}
