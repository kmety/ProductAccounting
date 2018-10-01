package by.itstep.bevza.productAccounting.service.impls;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itstep.bevza.productAccounting.dao.ManagerDao;
import by.itstep.bevza.productAccounting.model.Manager;
import by.itstep.bevza.productAccounting.service.interfaces.IManagerService;

@Service
public class ManagerService implements IManagerService {
	@Autowired
	private ManagerDao managerDao;

	@Override
	public Optional<Manager> findByLogin(String login) {
		return managerDao.findByLogin(login);
	}

	@Override
	public void save(Manager manager) {
		managerDao.save(manager);
	}

}
