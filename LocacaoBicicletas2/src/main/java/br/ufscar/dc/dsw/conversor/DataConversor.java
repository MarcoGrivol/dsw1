package br.ufscar.dc.dsw.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.text.SimpleDateFormat; 


import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.service.spec.ILocacaoService;

@Component
public class DataConversor implements Converter<String, Date>{
	
	@Override
	public Date convert(String data) {
		
		if (data.isEmpty()) {
		 return null;	
        }
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
        Date data_aux = formato.parse(data);
        System.out.println(data);
        
        return data_aux;
	}
}