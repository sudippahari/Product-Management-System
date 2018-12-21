package com.sudip.DAO;

import java.util.List;

import com.sudip.product.Product;

public interface UserDAO {

	public Product displayProduct(int pid);
	public List<Product> displayAllProduct();
	public void Back();
}
