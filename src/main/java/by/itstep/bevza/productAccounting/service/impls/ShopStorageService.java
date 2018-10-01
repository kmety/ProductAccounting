package by.itstep.bevza.productAccounting.service.impls;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itstep.bevza.productAccounting.dao.ShopStorageDao;
import by.itstep.bevza.productAccounting.model.ShopStorage;
import by.itstep.bevza.productAccounting.service.interfaces.IShopStorageService;

@Service
public class ShopStorageService implements IShopStorageService {
	@Autowired
	private ShopStorageDao storageDao;

	@Override
	public List<ShopStorage> getStorageList(Long id) {
		return storageDao.findShopStorageByShopId(id);
	}

	public ShopStorage getStorageByShopIdAndProductId(Long shopId, Long productId) {
		return storageDao.findShopStorageByShopIdAndProductId(shopId, productId);
	}

	public ShopStorage getStorageByShopId(Long shopId) {
		return storageDao.getShopStorageByShopId(shopId);
	}

	public ShopStorage getById(Long id) {
		return storageDao.findById(id).orElse(null);
	}

	@Override
	public void putStorageItem(ShopStorage storageItem) {
		storageDao.save(storageItem);
	}

	@Override
	public List<ShopStorage> getListForTrading(Long shopId) {
		List<ShopStorage> resultList = storageDao.findShopStorageByShop_idNamedParamsNative(shopId);
		return resultList.stream().filter(item -> !false == item.getOnTrading()).collect(Collectors.toList());
	}

}
