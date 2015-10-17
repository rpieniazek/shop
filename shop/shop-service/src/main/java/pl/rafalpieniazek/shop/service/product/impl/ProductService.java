package pl.rafalpieniazek.shop.service.product.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.rafalpieniazek.shop.model.product.Product;
import pl.rafalpieniazek.shop.repo.base_repo.IBaseRepo;
import pl.rafalpieniazek.shop.service.product.IProductService;

@Transactional(rollbackOn=Exception.class)
@Service
public class ProductService implements IProductService {

	@Autowired
	private IBaseRepo<Product> productRepo;
	
	@Override
	public void save(Product product) {
		productRepo.save(product);
	}

	@Override
	public void delete(Product product) {
		productRepo.delete(product);

	}

	@Override
	public void update(Product product) {
		productRepo.update(product);
	}

	@Override
	public Product getById(long id) {
		return productRepo.getById(id);
	}

	@Override
	public List<Product> findAll() {
		return productRepo.findAll();
	}

}
