package pl.rafalpieniazek.shop.service.product.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.rafalpieniazek.shop.model.product.Product;
import pl.rafalpieniazek.shop.repo.base_repo.IBaseRepo;
import pl.rafalpieniazek.shop.repo.product.IProductRepo;
import pl.rafalpieniazek.shop.repo.product.impl.ProductReportDTO;
import pl.rafalpieniazek.shop.service.product.IProductService;

@Transactional(rollbackOn=Exception.class)
@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepo productRepo;
	
	@Override
	public void save(Product product) {
		productRepo.save(product);
	}

	@Override
	public void delete(Product product) {
		productRepo.delete(product);

	}

	@Override
	public void delete(Long productId) {
		productRepo.delete(productId);

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

	@Override
	public List<ProductReportDTO> report() {
		List<Object> objectsList =  productRepo.report();
		List<ProductReportDTO> result = new ArrayList<>();
		for (Object object : objectsList) {
			Object[] row = (Object[]) object;
			ProductReportDTO report = new ProductReportDTO();
			report.setOccurences((Long) row[0]);
			report.setCategory((String) row[1]);
			result.add(report);
		}
		return result;
	}


}
