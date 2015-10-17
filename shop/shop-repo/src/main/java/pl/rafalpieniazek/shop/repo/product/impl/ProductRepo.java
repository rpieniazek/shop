package pl.rafalpieniazek.shop.repo.product.impl;

import java.util.List;

import lombok.Setter;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.rafalpieniazek.shop.model.product.Product;
import pl.rafalpieniazek.shop.repo.base_repo.IBaseRepo;

@Repository
public class ProductRepo implements IBaseRepo<Product> {
	
	@Autowired
	@Setter
	SessionFactory session;
	
	@Override
	public void save(Product entity) {
		session.getCurrentSession().save(entity);
	}

	@Override
	public void delete(Product entity) {
		session.getCurrentSession().delete(entity);	
	}

	@Override
	public void update(Product entity) {
		session.getCurrentSession().update(entity);
		
	}

	@Override
	public Product getById(long id) {
		return (Product) session.getCurrentSession().get(Product.class, id);

	}

	@Override
	public List<Product> findAll() {
		return session.getCurrentSession().createCriteria(Product.class).list();

	}
	
	

}
