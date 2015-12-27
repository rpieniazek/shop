package pl.rafalpieniazek.shop.service.user;

import java.util.List;

import pl.rafalpieniazek.shop.model.user.User;


public interface IUserService {
	
 	void save(User user);
	
	 void delete(User user);
	
	 void update(User user);
	
	 User getById (long id);
	
	 List<User> findAll();

	List userQuery(String name);
}
