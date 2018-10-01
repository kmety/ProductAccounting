package by.itstep.bevza.productAccounting.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import by.itstep.bevza.productAccounting.model.ShopStorage;

public interface ShopStorageDao extends CrudRepository<ShopStorage, Long> {

	@Query(value = "SELECT * FROM Shop_storage storage WHERE storage.shop_id = :shop_id", nativeQuery = true)
	public List<ShopStorage> findShopStorageByShop_idNamedParamsNative(@Param("shop_id") Long shopId);

	@Query(value = "UPDATE Shop_storage storage SET storage.fact_price = :fact_price, storage.on_trading = :on_trading WHERE storage.id = :id", nativeQuery = true)
	public List<ShopStorage> updateShopStorageNamedParamsNative(@Param("fact_price") Double fact_price,
			@Param("on_trading") Boolean onTrading, @Param("id") Long id);

	public List<ShopStorage> findShopStorageByShopId(Long shopId);

	public ShopStorage findShopStorageByShopIdAndProductId(Long shopId, Long productId);

	public ShopStorage getShopStorageByShopId(Long shopId);

}
