package pl.rafalpieniazek.shop.webapp.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.rafalpieniazek.shop.model.product.Product;
import pl.rafalpieniazek.shop.service.product.impl.ProductService;

@Controller
@RequestMapping("admin/products")
public class ProductController {

	@Autowired
	private ProductService productService;


	@RequestMapping(value = {"/list/","/list"})
	public String getList(Model model){
		model.addAttribute("products",productService.findAll());
		return "admin/products/list";
	}

	@RequestMapping(method=RequestMethod.GET)
	public String getProduct(Model model){
		
//		productService.save(new Product("Pierwszy", 1));
//		productService.save(new Product("Drugi", 2));
		model.addAttribute(productService.findAll());
		
		return "products";
	}
	
}
