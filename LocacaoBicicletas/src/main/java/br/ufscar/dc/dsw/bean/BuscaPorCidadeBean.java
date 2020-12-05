package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.domain.Locadora;
import java.util.List;

public class BuscaPorCidadeBean {

    public List<Locadora> getLocadoras(String cidade) {
        LocadoraDAO dao = new LocadoraDAO();
        if (cidade == null || cidade.length() == 0 || cidade.contentEquals("todasCidades"))
        {
        	return dao.getAll();
        }
        return dao.getbyCidade(cidade);
    }
         
}