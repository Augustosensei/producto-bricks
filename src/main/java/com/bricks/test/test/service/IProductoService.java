package com.bricks.test.test.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bricks.test.test.entities.Producto;

public interface IProductoService {

	Page<Producto> findByProductoNamePrice(String name, Double price, Double stock, Integer category,
			Pageable pageable);

	Producto obtenerTPorId(Integer id) throws Exception;

	Producto guardar(Producto producto) throws Exception;

	Producto modificar(Producto producto) throws Exception;

	void eliminarPorId(Integer id) throws Exception;
}
