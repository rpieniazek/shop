package pl.rafalpieniazek.shop.repo.category.impl;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.rafalpieniazek.shop.model.category.Category;
import pl.rafalpieniazek.shop.repo.base_repo.IBaseRepo;


@Repository
public class CategoryRepo implements IBaseRepo<Category> {
	
	@Autowired
	SessionFactory session;
	@Override
	public void save(Category entity) {
		session.getCurrentSession().save(entity);
		
	}

	@Override
	public void delete(Category entity) {
		session.getCurrentSession().delete(entity);	
		
	}

	@Override
	public void update(Category entity) {
		session.getCurrentSession().update(entity);
		
	}

	@Override
	public Category getById(long id) {
		return (Category) session.getCurrentSession().get(Category.class, id);
	}

	@Override
	public List<Category> findAll() {
		return session.getCurrentSession().createCriteria(Category.class).list();
	}

}
