package by.itstep.bevza.productAccounting.service.impls;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itstep.bevza.productAccounting.dao.ProductDao;
import by.itstep.bevza.productAccounting.dao.ShopDao;
import by.itstep.bevza.productAccounting.model.Product;
import by.itstep.bevza.productAccounting.model.Shop;
import by.itstep.bevza.productAccounting.service.interfaces.IShopService;

@Service
public class ShopService implements IShopService {

	@Autowired
	private ShopDao shopDao;
	@Autowired
	private ProductDao productDao;

	@PostConstruct
	public void initShops() {
		if (shopDao.findAll() != null) {
			firstInit();
		}
	}

	@Override
	public Shop add(Shop shop) {
		return shopDao.save(shop);
	}

	@Override
	public List<Shop> getShops() {
		return (List<Shop>) shopDao.findAll();
	}

	@Override
	public Optional<Shop> getShopById(Long id) {
		return shopDao.findById(id);
	}

	private void firstInit() {
		Shop shop = new Shop();
		shop.setId(1L);
		shop.setName("Shop1");
		shopDao.save(shop);
		shop = new Shop();
		shop.setId(2L);
		shop.setName("Shop2");
		shopDao.save(shop);
		shop = new Shop();
		shop.setId(3L);
		shop.setName("Shop3");
		shopDao.save(shop);

		Product product = new Product();
		product.setName("Чайник стальной");
		product.setInfo("зеркальный с несъемным свистком на кнопке и ручкой в силиконовой "
				+ "оболочке серого цвета подходит для всех типов плит, включая индукцию");
		productDao.save(product);
		product = new Product();
		product.setName("Lemon");
		product.setInfo("Very sour Lemons!!");
		productDao.save(product);
		product = new Product();
		product.setName("Apple");
		product.setInfo("Very round apples!");
		productDao.save(product);
		product = new Product();
		product.setName("Pomegranate");
		product.setInfo("Very red pomegranates!");
		productDao.save(product);
		product = new Product();
		product.setName("Melon");
		product.setInfo("Very yellow Melons!");
		productDao.save(product);
		product = new Product();
		product.setName("Watermelon");
		product.setInfo("Very big Watermelons!");
		productDao.save(product);
		product = new Product();
		product.setName("Plum");
		product.setInfo("Very blue Plums!");
		productDao.save(product);
		product = new Product();
		product.setName("Lime");
		product.setInfo("Very green Limes!");
		productDao.save(product);
	}
}
