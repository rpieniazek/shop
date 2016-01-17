package pl.rafalpieniazek.shop.webapp.controller;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.rafalpieniazek.shop.model.product.Product;
import pl.rafalpieniazek.shop.model.user.User;
import pl.rafalpieniazek.shop.service.product.IProductService;
import pl.rafalpieniazek.shop.service.user.IUserService;

import java.util.List;


@Controller
@Log4j
public class HomeController {


    @RequestMapping(value = {"", "/"})
    public String home() {
        return "index";
    }


    @RequestMapping(value = {"/admin", "/admin/"})
    public String adminHome() {
        return "admin/index";
    }
}


