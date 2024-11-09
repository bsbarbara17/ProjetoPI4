package com.projeto.DAO;

import java.util.List;

import com.projeto.model.Produto;

public interface ProdutoDAO {
	void save(Produto produto);
	void update(Produto produto);
	void delete(Long id);
	Produto findById(Long id);
	List<Produto> findAll();
}
