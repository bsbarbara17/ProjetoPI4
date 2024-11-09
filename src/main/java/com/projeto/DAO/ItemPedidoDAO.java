package com.projeto.DAO;

import java.util.List;

import com.projeto.model.ItemPedido;

public interface ItemPedidoDAO {
	void save(ItemPedido itemPedido);
	void update(ItemPedido itemPedido);
	void delete(Long id);
	ItemPedido findById(Long id);
	List<ItemPedido> findAll();
}
