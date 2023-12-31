package br.tche.ucpel.bd2.dao;

import br.tche.ucpel.bd2.bean.Departamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Pseudo DAO (Data Access Objetc) para realizar as operações de CRUD -
 * expressão em língua Inglesa Create, Retrieve, Update e Delete.
 * <h1>ATENÇÃO! Para simplificar o entendimento, não foi aplicada o real pattern
 * DAO!!!!</h1>
 *
 * @author mertins
 */
public class DepartamentoDAO {

    private Connection conexao;

    /**
     * Construtor único, para garantir a existência de uma conexão com um SGBD
     *
     * @param conexao Connection já aberta com um SGBD
     */
    public DepartamentoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * Se o departamento for válido, este método irá fazer o INSERT no SGBD. O
     * Código será inserido pela Sequência e será colocado novamente no objeto
     * Departamento.
     *
     * @param dept Departamento a ser inserido
     * @throws java.sql.SQLException Qualquer erro entre o Sistema e o Banco
     * será devolvido nesta Exceção
     */
    public void create(Departamento dept) throws SQLException {
        if (this.valida(dept)) {
            String sql = "INSERT INTO DEPARTAMENTO (COD,DESCRICAO,LOCALIZACAO) VALUES (NEXTVAL('SEQDEPARTAMENTO'),?,?)";            // Insert Postgresql
           // String sql = "INSERT INTO DEPARTAMENTO (COD,DESCRICAO,LOCALIZACAO) VALUES (NEXT VALUE FOR SEQDEPARTAMENTO,?,?)";          // Insert Java DB 
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setString(1, dept.getDescricao());
            pst.setString(2, dept.getLocalizacao());
            pst.executeUpdate();
            Statement st = this.conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT CURRVAL('SEQDEPARTAMENTO')");     // Select sequence Postgresql
            //ResultSet rs = st.executeQuery("SELECT MAX(COD) FROM DEPARTAMENTO");       // Select sequence Java DB
            if (rs.next()) {
                dept.setCod(rs.getInt(1));
            }
            rs.close();
            st.close();
            pst.close();
        }
    }

    /**
     * Retorna o departamento do SGBD de acordo com o código do departamento
     * recebido.
     *
     * @param dept Departamento a ser carregado do SGBD
     * @return Departamento do SGBD
     * @throws java.sql.SQLException Qualquer erro entre o Sistema e o Banco
     * será devolvido nesta Exceção
     */
    public Departamento retrieve(Departamento dept) throws SQLException {
        Departamento deptRet = null;
        String sql = "SELECT COD,DESCRICAO,LOCALIZACAO FROM DEPARTAMENTO WHERE COD=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, dept.getCod());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            deptRet = new Departamento();
            deptRet.setCod(rs.getInt("COD"));
            deptRet.setDescricao(rs.getString("DESCRICAO"));
            deptRet.setLocalizacao(rs.getString("LOCALIZACAO"));
        }
        rs.close();
        pst.close();
        return deptRet;
    }

    /**
     * Atualiza o departamento no SGBD.
     *
     * @param dept Departamento a ser atualizado do SGBD
     * @throws java.sql.SQLException Qualquer erro entre o Sistema e o Banco
     * será devolvido nesta Exceção
     */
    public void update(Departamento dept) throws SQLException {
        if (this.valida(dept)) {
            String sql = "UPDATE DEPARTAMENTO SET DESCRICAO=? , LOCALIZACAO=? WHERE COD=?";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setString(1, dept.getDescricao());
            pst.setString(2, dept.getLocalizacao());
            pst.setInt(3, dept.getCod());
            pst.executeUpdate();
            pst.close();
        }
    }

    /**
     * Remove o código do departamento do SGBD.
     *
     * @param dept Departamento a ser excluído. Necessita apenas do atributo COD
     * @throws java.sql.SQLException Qualquer erro entre o Sistema e o Banco
     * será devolvido nesta Exceção
     */
    public void delete(Departamento dept) throws SQLException {
        String sql = "DELETE FROM DEPARTAMENTO WHERE COD=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, dept.getCod());
        pst.executeUpdate();
        pst.close();
    }

    /**
     * Retorna uma Lista com todos os Departamentos cadastrados no SGBD.
     *
     * @return Lista com os departamentos.
     * @throws java.sql.SQLException Qualquer erro entre o Sistema e o Banco
     * será devolvido nesta Exceção
     */
    public List<Departamento> listaTodos() throws SQLException {
        List<Departamento> lista = new ArrayList<Departamento>();
        String sql = "SELECT COD,DESCRICAO,LOCALIZACAO FROM DEPARTAMENTO ORDER BY COD";
        Statement st = this.conexao.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Departamento dept = new Departamento(rs.getInt("COD"), rs.getString("DESCRICAO"), rs.getString("LOCALIZACAO"));
            lista.add(dept);
        }
        rs.close();
        st.close();
        return lista;
    }

    /**
     * Aplica os testes para as regras de negócio.
     *
     * @param dept Departamento a ser testado
     * @return true se o Departamento atende as regras de negócio, ou false em
     * caso contrário.
     */
    public boolean valida(Departamento dept) {
        boolean ret = false;
        if (dept != null) {
            ret = true;
        }
        return ret;
    }
}
