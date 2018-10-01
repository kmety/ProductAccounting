package by.itstep.bevza.productAccounting.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import by.itstep.bevza.productAccounting.model.Product;

@Service
public interface IProductService {
	public List<Product> getProducts();

	public Product addProduct(Product product);

	public Product getById(Long id);
	
	public Optional<Product> findByName(String name);
}
