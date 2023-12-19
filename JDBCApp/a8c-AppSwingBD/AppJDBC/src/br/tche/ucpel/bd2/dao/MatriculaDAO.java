package br.tche.ucpel.bd2.dao;

import br.tche.ucpel.bd2.bean.Aluno;
import br.tche.ucpel.bd2.bean.Departamento;
import br.tche.ucpel.bd2.bean.Disciplina;
import br.tche.ucpel.bd2.bean.Funcionario;
import br.tche.ucpel.bd2.bean.Matricula;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO {

    private Connection conexao;

    public MatriculaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void create(Matricula matricula) throws SQLException {
        if (this.valida(matricula)) {
            String sql = " insert into matricula (matriculaaluno, coddisciplina) "
                    + // Insert Postgresql
                    " VALUES ( ?, ?)";

            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setInt(2, matricula.getDisciplina().getCod());
            pst.setInt(1, matricula.getAluno().getMatricula());

            pst.executeUpdate();

            pst.close();
        }
    }

    public Matricula retrieve(Matricula matricula) throws SQLException {
        Matricula funcRet = null;
        String sql = "SELECT matricaaluno, coddiscilpina FROM matricula WHERE coddisciplina=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, matricula.getDisciplina().getCod());
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            DisciplinaDAO discDAO = new DisciplinaDAO(conexao);
            Disciplina disc = new Disciplina(rs.getInt("coddisciplina"));
            disc = discDAO.retrieve(disc);
            funcRet.setDisciplina(disc);

        }
        rs.close();
        pst.close();
        return funcRet;
    }

    public void update(Matricula matricula) throws SQLException {
        if (this.valida(matricula)) {
            String sql = "UPDATE matricula SET matriculaaluno=?, coddisciplina=? WHERE coddisciplina=?";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setInt(1, matricula.getAluno().getMatricula());
            pst.setInt(2, matricula.getDisciplina().getCod());
            pst.setInt(3, matricula.getDisciplina().getCod()); // Configurar o terceiro parâmetro

            pst.executeUpdate();
            pst.close();
        }
    }

    public void delete(Matricula matricula) throws SQLException {
        String sql = "DELETE FROM matricula WHERE matriculaaluno=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, matricula.getAluno().getMatricula());
        pst.executeUpdate();
        pst.close();
    }

    /**
     * Retorna uma Lista com todos os Funcionarios cadastrados no SGBD.
     *
     * @return Lista com os funcionarios.
     * @throws java.sql.SQLException Qualquer erro entre o Sistema e o Banco
     * será devolvido nesta Exceção
     */
    public List<Matricula> listaTodos() throws SQLException {
        List<Matricula> lista = new ArrayList<Matricula>();
        String sql = "SELECT matriculaaluno, coddisciplina FROM matricula ORDER BY coddisciplina";
        Statement st = this.conexao.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Matricula mat = new Matricula();
            
            DisciplinaDAO discDAO = new DisciplinaDAO(conexao);
            Disciplina disc = new Disciplina(rs.getInt("coddisciplina"));
            disc = discDAO.retrieve(disc);
            mat.setDisciplina(disc);
            
            AlunoDAO alunoDAO = new AlunoDAO(conexao);
            Aluno aluno = new Aluno(rs.getInt("matriculaaluno"));
            aluno = alunoDAO.retrieve(aluno);
            mat.setAluno(aluno);
            
            lista.add(mat);
        }
        rs.close();
        st.close();
        return lista;
    }

    /**
     * Aplica os testes para as regras de negócio.
     *
     * @param func Funcioanario a ser testado
     * @return true se o Funcionario atende as regras de negócio, ou false em
     * caso contrário.
     */
    public boolean valida(Matricula func) {
        boolean ret = false;
        if (func != null) {
            ret = true;
        }
        return ret;
    }
}
