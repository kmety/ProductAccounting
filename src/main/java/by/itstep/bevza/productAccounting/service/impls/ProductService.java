package by.itstep.bevza.productAccounting.service.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itstep.bevza.productAccounting.dao.ProductDao;
import by.itstep.bevza.productAccounting.model.Product;
import by.itstep.bevza.productAccounting.service.interfaces.IProductService;

@Service
public class ProductService implements IProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getProducts() {
		return (List<Product>) productDao.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		return productDao.save(product);
	}

	@Override
	public Product getById(Long id) {
		return productDao.findById(id).get();
	}

	@Override
	public Optional<Product> findByName(String name) {
		
		return productDao.findByName(name);
	}
}
