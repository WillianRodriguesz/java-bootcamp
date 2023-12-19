package br.tche.ucpel.tads.doo1.comunicacaorede.util;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author mertins
 */
public class Mensagem implements Serializable{
      private int id;
      private Date data;
      private int codigo;
      private String texto;

    public Mensagem() {
    }

    public Mensagem(int id, Date data, String texto) {
        this.id = id;
        this.data = data;
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mensagem other = (Mensagem) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        return hash;
    }
      
}
