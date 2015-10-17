package pl.rafalpieniazek.shop.service.category.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.rafalpieniazek.shop.model.category.Category;
import pl.rafalpieniazek.shop.repo.base_repo.IBaseRepo;
import pl.rafalpieniazek.shop.service.category.ICategoryService;

@Transactional
@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	private IBaseRepo<Category > categoryRepo;
	
	@Override
	public void save(Category category) {
		categoryRepo.save(category);
	}

	@Override
	public void delete(Category category) {
		categoryRepo.delete(category);
	}

	@Override
	public void update(Category category) {
		categoryRepo.update(category);
	}

	@Override
	public Category getById(long id) {
		return categoryRepo.getById(id);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}
	

}
