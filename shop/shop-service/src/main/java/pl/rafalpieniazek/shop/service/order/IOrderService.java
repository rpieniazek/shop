package pl.rafalpieniazek.shop.service.order;

import java.util.List;

import pl.rafalpieniazek.shop.model.order.Order;

public interface IOrderService {

public void save(Order order);
	
	public void delete(Order order);
	
	public void update(Order order);
	
	public Order getById (long id);
	
	public List<Order> findAll();
	
}
