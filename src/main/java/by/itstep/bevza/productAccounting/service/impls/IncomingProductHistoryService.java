package by.itstep.bevza.productAccounting.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itstep.bevza.productAccounting.dao.IncomingProductHistoryDao;
import by.itstep.bevza.productAccounting.model.IncomingProductHistory;
import by.itstep.bevza.productAccounting.service.interfaces.IIncomingProductHistory;

@Service
public class IncomingProductHistoryService implements IIncomingProductHistory {

	@Autowired
	private IncomingProductHistoryDao incomeDao;

	@Override
	public void addIncomeProduct(IncomingProductHistory incomeProduct) {
		incomeDao.save(incomeProduct);
	}

	@Override
	public List<IncomingProductHistory> getAllIncomeProducts() {
		return (List<IncomingProductHistory>) incomeDao.findAll();
	}
}
