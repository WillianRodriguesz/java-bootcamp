package com.mycompany.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBC {
    private Connection conexao;

    private boolean connect() {
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "teste12");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, "Falha na conexão", ex);
            return false;
        }
    }

    private void disconnect() {
        try {
            if (conexao != null) {
                conexao.close();
                System.out.println("Conexão fechada com sucesso!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, "Erro ao fechar a conexão", ex);
        }
    }

    public void criaEstrutura() {
        if (!connect()) {
            System.out.println("Falha na conexão. Saindo...");
            return;
        }

        try (Statement st = this.conexao.createStatement()) {
            String sqlDDL = "CREATE SEQUENCE SEQTESTEJDBC";
            st.executeUpdate(sqlDDL);

            sqlDDL = "CREATE TABLE testeJDBC ("
                    + "id NUMERIC DEFAULT NEXTVAL('SEQTESTEJDBC'), "
                    + "descricao VARCHAR(200), "
                    + "PRIMARY KEY(id))";
            st.execute(sqlDDL);

            System.out.println("Estrutura criada com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, "Erro ao criar a estrutura", ex);
        } finally {
            disconnect(); // Feche a conexão no final do método criaEstrutura
        }
    }

    public void insereRegistro() {
        Logger logs = Logger.getLogger(JDBC.class.getName());

        try (Statement st = this.conexao.createStatement()) {
            String sqlDLL = "INSERT INTO testeJDBC (descricao) VALUES ('valor 2')";
            int ret = st.executeUpdate(sqlDLL);
            logs.log(Level.INFO, String.format("Número de registros inseridos: %s", ret));

            sqlDLL = "INSERT INTO testeJDBC (ID, DESCRICAO) VALUES (120, 'VALOR 2')";
            ret = st.executeUpdate(sqlDLL);
            logs.log(Level.INFO, String.format("Número de registros inseridos: %s", ret));

        } catch (SQLException ex) {
            logs.log(Level.SEVERE, "Erro ao inserir registros", ex);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        JDBC t = new JDBC();
        t.connect(); // Conectar antes de criar a estrutura
        //t.criaEstrutura();
        t.insereRegistro();
        t.disconnect(); // Fechar a conexão no final do programa
    }
}
