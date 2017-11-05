package com.iwcn.master.controllers;  

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iwcn.master.entities.Product;
import com.iwcn.master.services.ProductDataBase;
import com.iwcn.master.services.UserService;

@RestController
public class AppController {

    @Autowired
    private ProductDataBase Service;

    @RequestMapping(value = "/productList", method=RequestMethod.GET)
    public Iterable<Product> showProducts() {
        return Service.GetAll();
    }
    
    @RequestMapping(value = "/showProduct", method=RequestMethod.GET)
    public Product showProduct(@RequestParam long index) {
    	Product Producto = Service.GetProduct(index);
    	return Producto;
        //return Service.GetProduct(index);
    }

    @RequestMapping(value = "/editProduct", method=RequestMethod.PUT)
    public void editProduct(@RequestBody Product product)
    {
    	this.Service.EditProduct(product);
    	return;
    }

    @RequestMapping(value = "/deleteProduct", method=RequestMethod.DELETE)
    public void deleteProduct(@RequestParam long index) {
    	Service.DeleteProduct(index);
        return;
    }
    
    @RequestMapping(value = "/addProduct", method=RequestMethod.POST)
    public void addProduct(@RequestBody Product product) {
    	Service.AddProduct(product);
        return;
    }

}
