package br.ufscar.dc.dsw.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.text.ParseException;
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
        Date data_aux = null;
		try {
			data_aux = formato.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(data);
        
        return data_aux;
	}
}