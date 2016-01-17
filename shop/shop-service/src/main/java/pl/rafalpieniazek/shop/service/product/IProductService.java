package pl.rafalpieniazek.shop.service.product;

import java.util.List;

import pl.rafalpieniazek.shop.model.product.Product;
import pl.rafalpieniazek.shop.repo.product.impl.ProductReportDTO;


public interface IProductService {
	
	
	void save(Product product);
	
	void delete(Product product);

	void delete(Long productId);

	void update(Product product);
	
	Product getById (long id);
	
	List<Product> findAll();

	List<ProductReportDTO> report();
}
