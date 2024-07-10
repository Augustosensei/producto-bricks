package com.bricks.test.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bricks.test.test.entities.Producto;
import com.bricks.test.test.repository.IProductoRepository;
import com.bricks.test.test.service.IProductoService;


@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
    private IProductoRepository productoRepository;

	@Override 
	public Page<Producto> findByProductoNamePrice(String name, Double price, Double stock, Integer category, Pageable pageable) {
	        return productoRepository.findByProductoNamePrice(name, price, stock, category, pageable);
	    }

	@Override
	public Producto obtenerTPorId(Integer id) throws Exception {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	public Producto guardar(Producto producto) throws Exception {
		return productoRepository.save(producto);
	}

	@Override
	public Producto modificar(Producto producto) throws Exception {
		return productoRepository.save(producto);
	}

	@Override
	public void eliminarPorId(Integer id) throws Exception {
		productoRepository.deleteById(id);
	}



}
