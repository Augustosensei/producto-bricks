package com.bricks.test.test.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.bricks.test.test.dtos.CategoriaDTO;

@FeignClient(name = "categoriaClient", url = "https://api.develop.bricks.com.ar")
public interface ICategoriaCliente {

	@GetMapping("/loyalty/category/producer")
	List<CategoriaDTO> getCategories();

}
