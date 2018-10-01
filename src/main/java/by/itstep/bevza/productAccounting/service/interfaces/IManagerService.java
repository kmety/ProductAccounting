package by.itstep.bevza.productAccounting.service.interfaces;

import java.util.Optional;

import org.springframework.stereotype.Service;

import by.itstep.bevza.productAccounting.model.Manager;

@Service
public interface IManagerService {
	public Optional<Manager> findByLogin(String login);

	public void save(Manager manager);
}
