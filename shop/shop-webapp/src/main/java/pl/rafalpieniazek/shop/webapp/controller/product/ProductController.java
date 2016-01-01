package pl.rafalpieniazek.shop.webapp.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.rafalpieniazek.shop.model.category.Category;
import pl.rafalpieniazek.shop.model.product.Product;
import pl.rafalpieniazek.shop.service.category.impl.CategoryService;
import pl.rafalpieniazek.shop.service.product.impl.ProductService;
import pl.rafalpieniazek.shop.webapp.form.ProductForm;

import java.sql.Date;

@Controller
@RequestMapping("admin/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = {"/list/","/list"})
	public String getList(Model model){
		model.addAttribute("products",productService.findAll());
		return "admin/products/list";
	}


	@RequestMapping(value = {"/add","/add/"}, method = RequestMethod.GET)
	public String showForm(Model model){
		model.addAttribute("productForm", new ProductForm());
		model.addAttribute("categories", categoryService.findAll());
		return "admin/products/add";
	}

	@RequestMapping(value = {"/add","/add/"}, method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("productForm") ProductForm form,
							 BindingResult result,
							 Model model
							 ){
		if(result.hasErrors()){
			return "admin/products/add";

		}

			Product product = new Product();
			product.setName(form.getName());
			Category category = categoryService.getById(form.getCategoryId());
			product.setCategory(category);
			product.setDescription(form.getDescription());
			product.setQuantity(form.getQuantity());
			product.setBrand(form.getBrand());
			product.setModel(form.getModel());
			product.setCreatedAt(new Date(System.currentTimeMillis()));

			productService.save(product);
			return "admin/products/add";




	}
}
