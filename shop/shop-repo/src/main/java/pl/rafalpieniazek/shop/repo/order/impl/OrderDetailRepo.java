package pl.rafalpieniazek.shop.repo.order.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.rafalpieniazek.shop.model.order.OrderDetail;
import pl.rafalpieniazek.shop.repo.base_repo.IBaseRepo;

@Repository 
public class OrderDetailRepo implements IBaseRepo<OrderDetail>{
	@Autowired
	SessionFactory session;
	
	@Override
	public void save(OrderDetail entity) {
		session.getCurrentSession().save(entity);
		
	}

	@Override
	public void delete(OrderDetail entity) {
		session.getCurrentSession().delete(entity);
		
	}

	@Override
	public void update(OrderDetail entity) {
		session.getCurrentSession().update(entity);
		
	}

	@Override
	public OrderDetail getById(long id) {
		return (OrderDetail) session.getCurrentSession().get(OrderDetail.class, id);
	}

	@Override
	public List<OrderDetail> findAll() {
		return session.getCurrentSession().createCriteria(OrderDetail.class).list();

	}

}
