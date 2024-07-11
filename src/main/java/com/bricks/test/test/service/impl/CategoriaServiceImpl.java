package com.bricks.test.test.service.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bricks.test.test.client.ICategoriaCliente;
import com.bricks.test.test.service.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

     @Autowired
    private ICategoriaCliente categoriaCliente;

    private AtomicInteger solicitudesDiarias = new AtomicInteger(0);

    @Override
    @Cacheable(value = "categoriasCache", unless = "#result == null")
    public List<Object> getCategorias() {
        if (solicitudesDiarias.get() >= 10) {
            throw new RuntimeException("Se ha alcanzado el límite diario de solicitudes");
        }
        
        // Incrementar el contador de solicitudes
        solicitudesDiarias.incrementAndGet();

        return categoriaCliente.getCategories();
    }
}
