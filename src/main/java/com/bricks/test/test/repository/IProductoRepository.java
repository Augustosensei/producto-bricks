package com.bricks.test.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bricks.test.test.entities.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {

	@Query("SELECT p FROM Producto p " + "WHERE (:name IS NULL OR p.name LIKE %:name%) "
			+ "AND (:price IS NULL OR p.price = :price) " + "AND (:stock IS NULL OR p.stock = :stock) "
			+ "AND (:category IS NULL OR p.category = :category)")
	Page<Producto> findByProductoNamePrice(@Param("name") String name, @Param("price") Double price,
			@Param("stock") Double stock, @Param("category") Integer category, Pageable pageable);

}
