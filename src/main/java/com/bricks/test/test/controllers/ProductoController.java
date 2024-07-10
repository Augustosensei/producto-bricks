package com.bricks.test.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bricks.test.test.entities.Producto;
import com.bricks.test.test.service.IProductoService;

@RestController
@RequestMapping("/product")
public class ProductoController {

	@Autowired
	private IProductoService productoService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<Producto> getProductos(@RequestParam(required = false) String name,
									   @RequestParam(required = false) Double price,
									   @RequestParam(required = false) Double stock,
									   @RequestParam(required = false) Integer category,
									   Pageable pageable) {
		return productoService.findByProductoNamePrice(name, price, stock, category, pageable);
	}
	

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Producto obtenerProductoPorId(@PathVariable(name = "id") Integer id) throws Exception {
		Producto obj = productoService.obtenerTPorId(id);
		return obj;

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Producto guardarProducto(@RequestBody Producto producto) throws Exception {
		Producto obj = productoService.guardar(producto);
		return obj;
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Producto modificarProducto(@RequestBody Producto producto) throws Exception {
		Producto obj = productoService.modificar(producto);
		return obj;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarProductoPorId(@PathVariable(name = "id") Integer id) throws Exception {
		productoService.eliminarPorId(id);
	}

}
