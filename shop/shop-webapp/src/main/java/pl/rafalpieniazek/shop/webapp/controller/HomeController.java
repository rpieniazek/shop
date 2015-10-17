package pl.rafalpieniazek.shop.webapp.controller;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.rafalpieniazek.shop.model.product.Product;
import pl.rafalpieniazek.shop.service.product.impl.ProductService;


@Controller
@Log4j
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = { "", "/" })
	public String home() {
		productService.save(new Product("Pierwszy", 1));
	//productService.save(new Product("Drugi", 2));
		System.out.println("HOMECONTROLER ");
		return "index";
	}


	@RequestMapping(value = { "/admin", "/admin/" })
	public String adminHome() {
		productService.save(new Product("Pierwszy", 1));
	//productService.save(new Product("Drugi", 2));
		System.out.println("ADMINCONTROLLER ");
		return "admin/index";
	}

}
