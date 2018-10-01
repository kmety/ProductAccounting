package by.itstep.bevza.productAccounting.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import by.itstep.bevza.productAccounting.model.IncomingProductHistory;

@Service
public interface IIncomingProductHistory {
	public void addIncomeProduct(IncomingProductHistory incomeProduct);

	public List<IncomingProductHistory> getAllIncomeProducts();

}
