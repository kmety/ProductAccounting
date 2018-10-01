package by.itstep.bevza.productAccounting.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import by.itstep.bevza.productAccounting.model.Manager;

public interface ManagerDao extends CrudRepository<Manager, Long> {

	public Optional<Manager> findByLogin(String login);
}
