package br.com.jethers.dashcard.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.jethers.dashcard.model.AgenteFinanceiro;

public interface AgenteFinanceiroDAO extends CrudRepository<AgenteFinanceiro, Integer>{
	
	public ArrayList<AgenteFinanceiro> findByOrderByVolumeDesc();

}