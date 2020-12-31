package br.ufscar.dc.dsw.service.impl;

import java.util.List;
import java.util.Optional;

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

}