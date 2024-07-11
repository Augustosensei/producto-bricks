package com.bricks.test.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bricks.test.test.client.ICategoriaCliente;
import com.bricks.test.test.service.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

	@Autowired
	private ICategoriaCliente categoriaCliente;

    @Override
    @Cacheable(value = "categoriasCache")
    public List<Object> getCategorias() {
        return categoriaCliente.getCategories();
    }


}
