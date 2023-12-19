package br.tche.ucpel.doo1.dao;

import br.tche.ucpel.doo1.bean.Pessoa;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author mertins
 */
public class PessoaDAO {
    // Esta variável static esta substituindo o Sistema Geranciador de Banco de Dados (SGBD)
    // que estaria presente em uma aplicação de verdade!
    private static Map baseDadosPessoa = new TreeMap();

    public void insere(Pessoa pessoa){
        baseDadosPessoa.put(pessoa.getCodigo(), pessoa);
    }

    public void atualiza(Pessoa pessoa){
        baseDadosPessoa.put(pessoa.getCodigo(), pessoa);
    }

    public void remover(Pessoa pessoa){
        baseDadosPessoa.remove(pessoa.getCodigo());
    }

    public Pessoa encontraPorCodigo(Integer codigo){
        return (Pessoa)baseDadosPessoa.get(codigo);
    }

    public Collection encontraTodos(){
        return baseDadosPessoa.values();
    }
}
