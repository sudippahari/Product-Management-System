package com.sudip.home;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.sudip.DAOImpl.UserDAOImpl;
import com.sudip.product.Product;

public class User {
	UserDAOImpl ud = new UserDAOImpl();
	Scanner sc = new Scanner(System.in);
	Product p = new Product();
	List<Product> products = new ArrayList<Product>();
	
	public void displayUserGreeting(){
		System.out.println("------------------------------------------------------------");
		System.out.println("|              Welcome to User Page                        |");
		System.out.println("------------------------------------------------------------");
		System.out.println("");
	}
	public void userControls(){
		System.out.println("Enter a choice: ");
		System.out.println("1. Display product");
		System.out.println("2. Display all product");
		System.out.println("3. Back menu");
		System.out.println("");
		
		int choice = sc.nextInt();
		switch(choice){
		case 1: System.out.println("Displaying product");
				System.out.println("Enter the product ID of product you wish to display: ");
				p = ud.displayProduct(sc.nextInt());
				System.out.println("The product is displayed below");
				if(p.getPid() == 0){
					System.out.println("There are no products to display");
				}else{
				System.out.println(p.toString());
				}
				break;
		case 2: System.out.println("Displaying all products");
				products = ud.displayAllProduct();
				System.out.println("The products are displayed below");
				//for (int i = 0; i < products.size(); i++){
				//	System.out.println(products.get(i));
				//}
				for (Product p : products){
					System.out.println(p);
				}
				break;
		case 3: System.out.println("Going back to Main Menu");
				ud.Back();
				break;
				
		}
	}
	

}
