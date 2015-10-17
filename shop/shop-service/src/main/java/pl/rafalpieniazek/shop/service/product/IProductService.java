package pl.rafalpieniazek.shop.service.product;

import java.util.List;

import pl.rafalpieniazek.shop.model.product.Product;


public interface IProductService {
	
	
public void save(Product product);
	
	public void delete(Product product);
	
	public void update(Product product);
	
	public Product getById (long id);
	
	public List<Product> findAll();
	
}
