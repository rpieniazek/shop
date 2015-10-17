package pl.rafalpieniazek.shop.repo.order.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.rafalpieniazek.shop.model.order.Order;
import pl.rafalpieniazek.shop.repo.base_repo.IBaseRepo;

@Repository 
public class OrderRepo implements IBaseRepo<Order>{

	@Autowired
	SessionFactory session;
	
	
	@Override
	public void save(Order entity) {
		session.getCurrentSession().save(entity);
		
	}

	@Override
	public void delete(Order entity) {
		session.getCurrentSession().delete(entity);	
		
	}

	@Override
	public void update(Order entity) {
		session.getCurrentSession().update(entity);
		
	}

	@Override
	public Order getById(long id) {
		return (Order) session.getCurrentSession().get(Order.class, id);

	}

	@Override
	public List<Order> findAll() {
		return session.getCurrentSession().createCriteria(Order.class).list();

	}
	

}
