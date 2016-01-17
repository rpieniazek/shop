package pl.rafalpieniazek.shop.repo.product;

import com.sun.prism.impl.BaseResourceFactory;
import pl.rafalpieniazek.shop.model.product.Product;
import pl.rafalpieniazek.shop.repo.base_repo.IBaseRepo;
import pl.rafalpieniazek.shop.repo.product.impl.ProductReportDTO;

import java.util.List;

/**
 * Created by Rafal on 2016-01-17.
 */
public interface IProductRepo extends IBaseRepo<Product> {

     void delete(Long id);

     List<Object> report();
}
