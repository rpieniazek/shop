package pl.rafalpieniazek.shop.service.order.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.rafalpieniazek.shop.model.order.Order;
import pl.rafalpieniazek.shop.repo.base_repo.IBaseRepo;
import pl.rafalpieniazek.shop.service.order.IOrderService;


@Transactional
@Service
public class OrderService implements IOrderService {
	
	
	@Autowired
	private IBaseRepo<Order> orderRepo;
	
	@Override
	public void save(Order order) {
		orderRepo.save(order);
		
	}

	@Override
	public void delete(Order order) {
		orderRepo.delete(order);
		
	}

	@Override
	public void update(Order order) {
		orderRepo.update(order);
	}

	@Override
	public Order getById(long id) {
		return orderRepo.getById(id);
	}

	@Override
	public List<Order> findAll() {
		return orderRepo.findAll();
	}

}
