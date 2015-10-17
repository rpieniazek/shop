package pl.rafalpieniazek.shop.service.order.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.rafalpieniazek.shop.model.order.OrderDetail;
import pl.rafalpieniazek.shop.repo.base_repo.IBaseRepo;
import pl.rafalpieniazek.shop.service.order.IOrderDetailService;


@Transactional
@Service
public class OrderDetailService implements IOrderDetailService {
	
	@Autowired
	private IBaseRepo<OrderDetail> orderDetailRepo;
	
	@Override
	public void save(OrderDetail orderDetail) {
		orderDetailRepo.save(orderDetail);		
	}

	@Override
	public void delete(OrderDetail orderDetail) {
		orderDetailRepo.delete(orderDetail);
	}

	@Override
	public void update(OrderDetail orderDetail) {
		orderDetailRepo.update(orderDetail);
	}

	@Override
	public OrderDetail getById(long id) {
		return orderDetailRepo.getById(id);
	}

	@Override
	public List<OrderDetail> findAll() {
		return orderDetailRepo.findAll();
	}

}
