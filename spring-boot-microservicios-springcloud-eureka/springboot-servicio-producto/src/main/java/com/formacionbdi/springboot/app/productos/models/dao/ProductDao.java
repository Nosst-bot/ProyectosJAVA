package com.formacionbdi.springboot.app.productos.models.dao;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Producto, Long> {

}
