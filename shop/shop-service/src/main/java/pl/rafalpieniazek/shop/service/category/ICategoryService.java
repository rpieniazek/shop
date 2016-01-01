package pl.rafalpieniazek.shop.service.category;

import java.util.List;

import pl.rafalpieniazek.shop.model.category.Category;

public interface ICategoryService {
	
public void save(Category category);
	
	public void delete(Category category);
	
	public void update(Category category);
	
	public Category getById (long id);
	
	public List<Category> findAll();

}
