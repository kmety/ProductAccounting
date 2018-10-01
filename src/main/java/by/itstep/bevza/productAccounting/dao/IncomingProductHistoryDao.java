package by.itstep.bevza.productAccounting.dao;

import org.springframework.data.repository.CrudRepository;

import by.itstep.bevza.productAccounting.model.IncomingProductHistory;

public interface IncomingProductHistoryDao extends CrudRepository<IncomingProductHistory, Long> {

}
