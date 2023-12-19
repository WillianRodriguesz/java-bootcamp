package br.tche.ucpel.doo1.dao;

import br.tche.ucpel.doo1.bean.Cidade;
import br.tche.ucpel.doo1.bean.Estado;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author mertins
 */
public class EstadoDAO {

    public static Set encontraTodos() {
        Set estados = new TreeSet();

        Estado e = new Estado(1, "Rio de Janeiro", "RJ");
        Cidade c = new Cidade(1, "Rio de Janeiro", e);
        e.getCidades().add(c);
        c = new Cidade(2, "Búzios", e);
        e.getCidades().add(c);
        estados.add(e);

        e = new Estado(2, "Rio Grande do Sul", "RS");
        c = new Cidade(3, "Pelotas", e);
        e.getCidades().add(c);
        c = new Cidade(4, "Rio Grande", e);
        e.getCidades().add(c);
        c = new Cidade(5, "São Lourenço", e);
        e.getCidades().add(c);
        estados.add(e);

        return estados;
    }
}
