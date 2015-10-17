package pl.rafalpieniazek.shop.service.user;

import java.util.List;

import pl.rafalpieniazek.shop.model.user.User;


public interface IUserService {
	
public void save(User user);
	
	public void delete(User user);
	
	public void update(User user);
	
	public User getById (long id);
	
	public List<User> findAll();
}
