package by.itstep.bevza.productAccounting.service.impls;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import by.itstep.bevza.productAccounting.model.Manager;

@Service
public class CustomManagerService implements UserDetailsService {
	@Autowired
	private ManagerService managerService;

	@Autowired
	private PasswordEncoder encoder;

	@PostConstruct
	public void init() {
		if (!managerService.findByLogin("manager").isPresent()) {
			Manager manager = new Manager();
			manager.setLogin("manager");
			manager.setPassword(encoder.encode("1111"));
			managerService.save(manager);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Manager user = managerService.findByLogin(login)
				.orElseThrow(() -> new UsernameNotFoundException("User not Found"));
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		org.springframework.security.core.userdetails.User man = new org.springframework.security.core.userdetails.User(
				user.getLogin(), user.getPassword(), true, true, true, true, authorities);
		return man;
	}

}
