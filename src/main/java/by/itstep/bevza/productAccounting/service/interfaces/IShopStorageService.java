package by.itstep.bevza.productAccounting.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import by.itstep.bevza.productAccounting.model.ShopStorage;

@Service
public interface IShopStorageService {

	public List<ShopStorage> getStorageList(Long shopId);

	public void putStorageItem(ShopStorage storageItem);

	public List<ShopStorage> getListForTrading(Long shopId);
}
