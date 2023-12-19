/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.tche.ucpel.bd2.dao;

import br.tche.ucpel.bd2.bean.Aluno;
import br.tche.ucpel.bd2.bean.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willian
 */
public class DisciplinaDAO {

    private Connection conexao;

    public DisciplinaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void create(Disciplina func) throws SQLException {

        if (this.valida(func)) {
            String sql = "INSERT INTO disciplina(cod, nome, turma, numalunos, cargahoraria) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pst = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, func.getCod());
            pst.setString(2, func.getNome());
            pst.setInt(3, func.getTurma());
            pst.setInt(4, func.getNumAlunos());
            pst.setInt(5, func.getCargaHoraria());

            pst.executeUpdate();

            // Obtendo as chaves geradas automaticamente 
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                func.setCod(rs.getInt(1));
            }

            rs.close();
            pst.close();
        }
    }

    public List<Disciplina> listaTodos() throws SQLException {
        List<Disciplina> lista = new ArrayList<Disciplina>();
        String sql = "select cod, nome, turma, numalunos, cargahoraria from  DISCIPLINA order by nome";
        Statement st = this.conexao.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Disciplina func = new Disciplina();
            func.setCod(rs.getInt("COD"));
            func.setNome(rs.getString("NOME"));
            func.setTurma(rs.getInt("TURMA"));
            func.setNumAlunos(rs.getInt("NUMALUNOS"));
            func.setCargaHoraria(rs.getInt("CARGAHORARIA"));
            lista.add(func);
        }

        rs.close();
        st.close();
        return lista;
    }

    public void delete(Disciplina disciplina) throws SQLException {
        String sql = "DELETE FROM DISCIPLINA WHERE COD=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, disciplina.getCod());
        pst.executeUpdate();
        pst.close();
    }

    public Disciplina findById(int cod) throws SQLException {
        String sql = "select * from disciplina where cod=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, cod);

        Disciplina disRet = null;
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            disRet = new Disciplina();
            disRet.setCod(rs.getInt("COD"));
            disRet.setNome(rs.getString("NOME"));
            disRet.setTurma(rs.getInt("TURMA"));
            disRet.setNumAlunos(rs.getInt("NUMALUNOS"));
            disRet.setCargaHoraria(rs.getInt("CARGAHORARIA")); 
        }

        return disRet;
    }

    public Disciplina retrieve(Disciplina disciplina) throws SQLException {
        Disciplina disRet = null;
        String sql = "select cod, nome, turma, numalunos, cargahoraria from  DISCIPLINA where cod=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, disciplina.getCod());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            disRet = new Disciplina();
            disRet.setCod(rs.getInt("COD"));
            disRet.setNome(rs.getString("NOME"));
            disRet.setTurma(rs.getInt("TURMA"));
            disRet.setNumAlunos(rs.getInt("NUMALUNOS"));
            disRet.setCargaHoraria(rs.getInt("CARGAHORARIA"));

        }
        rs.close();
        pst.close();
        return disRet;

    }

    public boolean valida(Disciplina func) {
        boolean ret = false;
        if (func != null) {
            ret = true;
        }
        return ret;
    }
}
