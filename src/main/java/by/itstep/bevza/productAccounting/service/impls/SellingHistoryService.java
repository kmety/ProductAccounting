package by.itstep.bevza.productAccounting.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itstep.bevza.productAccounting.dao.SellingHistoryDao;
import by.itstep.bevza.productAccounting.model.SellingHistory;
import by.itstep.bevza.productAccounting.service.interfaces.ISellingHistoryService;

@Service
public class SellingHistoryService implements ISellingHistoryService {

	@Autowired
	private SellingHistoryDao sellHistoryDao;

	@Override
	public List<SellingHistory> getSellingHistory(Long id) {
		return sellHistoryDao.findSellingHistoryByShop_idNamedParamsNative(id);
	}

	@Override
	public void putSellingHistory(SellingHistory sh) {
		sellHistoryDao.save(sh);
	}
}
