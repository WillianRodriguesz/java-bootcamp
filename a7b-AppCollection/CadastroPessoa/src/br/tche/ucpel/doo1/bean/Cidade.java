package br.tche.ucpel.doo1.bean;

/**
 *
 * @author mertins
 */
public class Cidade implements Comparable {

    private int id;
    private String descricao;
    private Estado estado;

    public Cidade() {
    }

    public Cidade(int id, String descricao, Estado estado) {
        this.id = id;
        this.descricao = descricao;
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
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
        hash = 79 * hash + this.id;
        return hash;
    }

    public int compareTo(Object o) {
        Cidade temp = (Cidade) o;
        return this.descricao.compareTo(temp.getDescricao());
    }
}
