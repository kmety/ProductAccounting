package by.itstep.bevza.productAccounting.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import by.itstep.bevza.productAccounting.model.SellingHistory;

@Service
public interface ISellingHistoryService {
	public List<SellingHistory> getSellingHistory(Long shopId);

	public void putSellingHistory(SellingHistory sh);

}
