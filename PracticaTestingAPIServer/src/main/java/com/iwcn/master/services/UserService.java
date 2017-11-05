package com.iwcn.master.services;

import org.springframework.stereotype.Service;

import com.iwcn.master.entities.Product;

import java.util.*;
@Service
public class UserService {

    LinkedList<Product> ProductsList_;
    public UserService() {
    	this.ProductsList_ = new LinkedList<Product>();
    }
    public void AddProduct(String name, float price, String description, String size, 
    		String origin, int yearLot, int monthLot, int dayLot) {
    	this.ProductsList_.addLast(new Product(name,price,description,size,origin,yearLot,monthLot,dayLot));
    }
    public void EditProduct(String name, float price, String description, String size, 
    		String origin, int yearLot, int monthLot, int dayLot, long index) {
    	this.ProductsList_.set((int) index, new Product(name,price,description,size,origin,yearLot,monthLot,dayLot));
    }
    public void DeleteProduct(long index) {
    	this.ProductsList_.remove((int)index);
    }
    public LinkedList<Product> GetAll(){
    	return this.ProductsList_;
    }
    public Product GetProduct(long index) {
    	return this.ProductsList_.get((int) index);
    }
}

