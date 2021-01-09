package br.ufscar.dc.dsw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ufscar.dc.dsw.dao.ILocadoraDAO;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.service.spec.ILocadoraService;

@Service
@Transactional(readOnly = false)
public class LocadoraService implements ILocadoraService {
	
	@Autowired
	ILocadoraDAO dao;

	public void salvar(Locadora locadora)
	{
		dao.save(locadora);
	}
	
	public void excluir(Long id)
	{
		dao.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public Locadora buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}
	
	@Transactional(readOnly = true)
	public List<Locadora> buscarTodos()
	{
		return dao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Locadora buscarLocadoraPorEmail(String email) {
		return dao.getLocadoraByEmail(email);
	}
	
	@Transactional(readOnly = true)
	public Locadora buscarLocadoraPorCnpj(String cnpj) {
		return dao.getLocadoraByCnpj(cnpj);
	}
	
	@Transactional(readOnly = true)
	public List<String> buscarTodasCidades() {
		return dao.getAllCities();
	}
	
	@Transactional(readOnly = true)
	public List<Locadora> buscarTodasPorCidade(String cidade) {
		return dao.getAllByCidade(cidade);
	}

	
}