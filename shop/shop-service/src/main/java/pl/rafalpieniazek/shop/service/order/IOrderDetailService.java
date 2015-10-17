package pl.rafalpieniazek.shop.service.order;

import java.util.List;

import pl.rafalpieniazek.shop.model.order.OrderDetail;

public interface IOrderDetailService {
	
public void save(OrderDetail orderDetail);
	
	public void delete(OrderDetail orderDetail);
	
	public void update(OrderDetail orderDetail);
	
	public OrderDetail getById (long id);
	
	public List<OrderDetail> findAll();
	
}
