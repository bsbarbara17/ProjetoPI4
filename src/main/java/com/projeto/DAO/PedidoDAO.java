package com.projeto.DAO;

import java.util.List;

import com.projeto.model.Pedido;

public interface PedidoDAO {
	void save(Pedido pedido);
	void update(Pedido pedido);
	void delete(Long id);
	Pedido findById(Long id);
	List<Pedido> findAll();
}
