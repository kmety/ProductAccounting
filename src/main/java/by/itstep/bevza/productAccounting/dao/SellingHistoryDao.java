package by.itstep.bevza.productAccounting.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import by.itstep.bevza.productAccounting.model.SellingHistory;

public interface SellingHistoryDao extends CrudRepository<SellingHistory, Long> {
	/*
	 * @Query(value = "select * from selling_history where shop_id=shop.id",
	 * nativeQuery = true) public List<SellingHistory> getByShopId(Long shopId);
	 */

	@Query(value = "SELECT * FROM Selling_History sh WHERE sh.shop_id = :shop_id", nativeQuery = true)
	public List<SellingHistory> findSellingHistoryByShop_idNamedParamsNative(@Param("shop_id") Long shopId);

	/*
	 * @Query(value =
	 * "SELECT * FROM Users u WHERE u.status = :status and u.name = :name",
	 * nativeQuery = true) User findUserByStatusAndNameNamedParamsNative(
	 * 
	 * @Param("status") Integer status, @Param("name") String name);
	 */
}
