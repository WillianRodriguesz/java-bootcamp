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
public class AlunoDAO {

    private Connection conexao;

    public AlunoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void create(Aluno func) throws SQLException {

        if (this.valida(func)) {
            String sql = "INSERT INTO aluno(matricula, nome, email, telefone, idade, dtnascimento) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, func.getMatricula());
            pst.setString(2, func.getNome());
            pst.setString(3, func.getEmail());
            pst.setString(4, func.getTelefone());
            pst.setInt(5, func.getIdade());
            java.sql.Date dtSQL = new java.sql.Date(func.getDtNascimento().getTime());
            pst.setDate(6, dtSQL);

            pst.executeUpdate();

            // Obtendo as chaves geradas automaticamente (incluindo a matrícula)
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                func.setMatricula(rs.getInt(1));
            }

            rs.close();
            pst.close();
        }
    }

    public List<Aluno> listaTodos() throws SQLException {
        List<Aluno> lista = new ArrayList<Aluno>();
        String sql = "SELECT MATRICULA, NOME, EMAIL, TELEFONE, IDADE, DTNASCIMENTO FROM ALUNO ORDER BY NOME";
        Statement st = this.conexao.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Aluno func = new Aluno();
            func.setMatricula(rs.getInt("MATRICULA"));
            func.setNome(rs.getString("NOME"));
            func.setEmail(rs.getString("EMAIL"));
            func.setTelefone(rs.getString("TELEFONE"));
            func.setIdade(rs.getInt("IDADE"));
            func.setDtNascimento(rs.getDate("DTNASCIMENTO"));
            lista.add(func);
        }

        rs.close();
        st.close();
        return lista;
    }

    public void delete(Aluno aluno) throws SQLException {
        String sql = "DELETE FROM ALUNO WHERE MATRICULA=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, aluno.getMatricula());
        pst.executeUpdate();
        pst.close();
    }

    public Aluno findById(int cod) throws SQLException {
        String sql = "select * from aluno where matricula=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, cod);

        Aluno alunoRet = null;
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            alunoRet = new Aluno();
            alunoRet.setMatricula(rs.getInt("MATRICULA"));
            alunoRet.setNome(rs.getString("NOME"));
            alunoRet.setEmail(rs.getString("EMAIL"));
            alunoRet.setTelefone(rs.getString("TELEFONE"));
            alunoRet.setIdade(rs.getInt("IDADE"));
            alunoRet.setDtNascimento(rs.getDate("DTNASCIMENTO"));

        }
    
        return alunoRet;
    }
    
    public Aluno retrieve(Aluno aluno) throws SQLException {
        Aluno alunoRet = null;
        String sql = "SELECT matricula, nome, email, telefone, idade, dtnascimento FROM ALUNO WHERE matricula=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, aluno.getMatricula());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            alunoRet = new Aluno();
            alunoRet.setMatricula(rs.getInt("MATRICULA"));
            alunoRet.setNome(rs.getString("NOME"));
            alunoRet.setEmail(rs.getString("EMAIL"));
            alunoRet.setTelefone(rs.getString("TELEFONE"));
            alunoRet.setIdade(rs.getInt("IDADE"));
            alunoRet.setDtNascimento(rs.getDate("DTNASCIMENTO"));

        }
        rs.close();
        pst.close();
        return alunoRet;
    }

    public boolean valida(Aluno func) {
        boolean ret = false;
        if (func != null) {
            ret = true;
        }
        return ret;
    }

}
