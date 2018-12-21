package com.sudip.DAO;

import java.util.List;

import com.sudip.product.Product;

public interface AdminDAO {
	
	public void addProduct(Product p);
	public void updateProduct(int pid);
	public void deleteProduct(int pid);
	public Product displayProduct(int pid);
	public List<Product> displayAllProduct();
	public void Back();

}
