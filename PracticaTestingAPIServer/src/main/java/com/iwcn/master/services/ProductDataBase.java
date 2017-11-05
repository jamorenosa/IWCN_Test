package com.iwcn.master.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.iwcn.master.entities.Product;

import org.springframework.data.repository.CrudRepository;

@Service
public class ProductDataBase {
	
	@Autowired
	private com.iwcn.master.repositories.ProductRepository ProductRepository;

    public void AddProduct(Product producto) {
    	this.ProductRepository.save(producto);
    }
    public void EditProduct(Product product) {
    	this.ProductRepository.save(product);
    }
    public void DeleteProduct(Long index) {
    	this.ProductRepository.delete(index);
    }
    public Iterable<Product> GetAll(){
    	return this.ProductRepository.findAll();
    }
    public Product GetProduct(long index) {
    	return this.ProductRepository.findOne(index);
    }
}
