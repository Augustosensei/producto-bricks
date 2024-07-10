package com.bricks.test.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bricks.test.test.service.ICategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private ICategoriaService categoriaService;

	@GetMapping
	public List<?> obtenerCategoriasDeProductores() {
		return categoriaService.getCategorias();
	}
}
