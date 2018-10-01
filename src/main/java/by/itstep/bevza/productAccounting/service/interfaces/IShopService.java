package by.itstep.bevza.productAccounting.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import by.itstep.bevza.productAccounting.model.Shop;

@Service
public interface IShopService {
	public Shop add(Shop shop);

	public List<Shop> getShops();

	public Optional<Shop> getShopById(Long id);
}
