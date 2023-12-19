package br.tche.ucpel.doo1.bean;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author mertins
 */
public class Estado implements Comparable{
    private int id;
    private String descricao;
    private String sigla;
    private Set cidades=new TreeSet();

    public Estado() {
    }

    public Estado(int id, String descricao, String sigla) {
        this.id = id;
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Set getCidades() {
        return cidades;
    }

    public void setCidades(Set cidades) {
        this.cidades = cidades;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estado other = (Estado) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        return hash;
    }

    public int compareTo(Object o) {
        Estado temp=(Estado)o;
        return this.descricao.compareTo(temp.getDescricao());
    }
}
