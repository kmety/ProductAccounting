package by.itstep.bevza.productAccounting.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import by.itstep.bevza.productAccounting.model.Product;

public interface ProductDao extends CrudRepository<Product, Long> {
	public Optional<Product> findByName(String name);

}
