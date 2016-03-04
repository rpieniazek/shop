package pl.rafalpieniazek.shop.webapp.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.rafalpieniazek.shop.model.category.Category;
import pl.rafalpieniazek.shop.model.product.Product;
import pl.rafalpieniazek.shop.repo.product.impl.ProductReportDTO;
import pl.rafalpieniazek.shop.service.category.impl.CategoryService;
import pl.rafalpieniazek.shop.service.product.impl.ProductService;
import pl.rafalpieniazek.shop.webapp.form.ProductForm;

import javax.validation.Valid;

import java.util.List;

@Controller
@RequestMapping("admin/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@ModelAttribute("categories")
	private List<Category> getCategoriesList(){
		return categoryService.findAll();
	}

	@RequestMapping(value = {"/list/","/list"})
	public String getList(Model model){
		model.addAttribute("products",productService.findAll());
		return "admin/products/list";
	}

	@RequestMapping(value = {"/add","/add/"}, method = RequestMethod.GET)
	public String showForm(Model model){
		model.addAttribute("productForm", new ProductForm());

		return "admin/products/add";
	}

	@RequestMapping(value = {"/add","/add/"}, method = RequestMethod.POST)
	public String submitForm(@Valid @ModelAttribute("productForm") ProductForm form,
							 BindingResult result,
							 Model model
							 ){
		if(result.hasErrors()){

			return "admin/products/add";
		}

			Product product = new Product();
			product = copyDataFromFormToEntity(product,form);
			productService.save(product);

			return "redirect:/admin/products/list";
	}

	@RequestMapping(value = {"/edit/{prodId}","/edit/{prodID}/"}, method = RequestMethod.GET)
	public String showEditForm(@PathVariable("prodId")Long productID, Model model){
		Product product = productService.getById(productID);
		if(product == null){
			return "redirect:/admin/products/list";
		}

		ProductForm productForm = new ProductForm(product);
		model.addAttribute("productForm", productForm);

		return "admin/products/add";
	}

	@RequestMapping(value = {"/edit","/edit/"}, method = RequestMethod.POST)
	public String submitEditForm(@Valid @ModelAttribute("productForm") ProductForm form,
							 BindingResult result
	){

		if(result.hasErrors()){

			return "admin/products/add";
		}
		Product product = productService.getById(form.getId());
		product = copyDataFromFormToEntity(product, form);

		productService.update(product);
		return "redirect:/admin/products/list";
	}

	@RequestMapping(value={"/delete/{prodId}","/delete/{prodId}/"}, method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("prodId") Long productId){
		productService.delete(productId);

		return "redirect:/admin/products/list";
	}


	@RequestMapping(value={"/report","/report/"}, method = RequestMethod.GET)
	public String report(Model model){
		List<ProductReportDTO>	reportList = productService.report();
		model.addAttribute(reportList);
		return "admin/products/report";
	}

	private Product copyDataFromFormToEntity(Product product, ProductForm form) {

		product.setName(form.getName());
		Category category = categoryService.getById(form.getCategoryId());
		product.setCategory(category);
		product.setDescription(form.getDescription());
		product.setQuantity(form.getQuantity());
		product.setBrand(form.getBrand());
		product.setModel(form.getModel());
		return product;
	}

}
