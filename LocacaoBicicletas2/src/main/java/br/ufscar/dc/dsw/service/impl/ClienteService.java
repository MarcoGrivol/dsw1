package br.ufscar.dc.dsw.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ufscar.dc.dsw.dao.IClienteDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.service.spec.IClienteService;

@Service
@Transactional(readOnly = false)
public class ClienteService implements IClienteService {
	
	@Autowired
	IClienteDAO dao;
	
	public void salvar(Cliente cliente)
	{
		dao.save(cliente);
	}
	
	public void excluir(String email)
	{
		dao.deleteById(email);
	}
	
	@Transactional(readOnly = true)
	public Optional<Cliente> buscarPorEmail(String email)
	{
		return dao.findById(email);
	}
	
	@Transactional(readOnly = true)
	public List<Cliente> buscarTodos()
	{
		return dao.findAll();
	}
}
