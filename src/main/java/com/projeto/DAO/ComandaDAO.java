package com.projeto.DAO;

import java.util.List;

import com.projeto.model.Comanda;

public interface ComandaDAO {
	void save(Comanda comanda);
	void update(Comanda comanda);
	void delete(Long id);
	Comanda findById(Long id);
	List<Comanda> findAll();
	
	

}
