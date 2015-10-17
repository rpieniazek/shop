package pl.rafalpieniazek.shop.service.user.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.rafalpieniazek.shop.model.user.User;
import pl.rafalpieniazek.shop.repo.base_repo.IBaseRepo;
import pl.rafalpieniazek.shop.service.user.IUserService;

@Service
@Transactional
public class UserService implements IUserService{
	
	@Autowired
	private IBaseRepo<User> userRepo;
	
	@Override
	public void save(User user) {
		userRepo.save(user);
		
	}

	@Override
	public void delete(User user) {
		userRepo.delete(user);
	}

	@Override
	public void update(User user) {
		userRepo.update(user);
	}

	@Override
	public User getById(long id) {
		return userRepo.getById(id);
	}

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	
}
