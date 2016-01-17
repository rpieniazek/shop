package pl.rafalpieniazek.shop.repo.product.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.Setter;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.rafalpieniazek.shop.model.product.Product;
import pl.rafalpieniazek.shop.repo.base_repo.IBaseRepo;
import pl.rafalpieniazek.shop.repo.product.IProductRepo;

@Repository
public class ProductRepo implements IProductRepo {
	
	@Autowired
	@Setter
	SessionFactory sessionFactory;
	
	@Override
	public void save(Product entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	public void delete(Product entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();

		Product product = (Product) session.createCriteria(Product.class).add(Restrictions.eq("Id", id)).uniqueResult();
		session.delete(product);
	}


	@Override
	public void update(Product entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public Product getById(long id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		criteria.setFetchMode("category",FetchMode.JOIN);
		criteria.add(Restrictions.eq("Id",id));
		return (Product) criteria.uniqueResult();
	}

	@Override
	public List<Product> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		criteria.createAlias("category", "category");
		criteria.setFetchMode("category", FetchMode.JOIN);

		return criteria.list();
	}

	@Override
	public List<Object> report() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		criteria.createAlias("category", "category");
		criteria.setProjection(
				Projections.projectionList()
						.add(Projections.count("Id"))
						.add(Projections.groupProperty("category.name"))
				);
		 return criteria.list();

	}


	public void test(){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
	}

}
