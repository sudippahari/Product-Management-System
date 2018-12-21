package com.sudip.home;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sudip.DAOImpl.AdminDAOImpl;
import com.sudip.product.Product;

public class Admin{

	AdminDAOImpl ad = new AdminDAOImpl();
	Scanner sc = new Scanner(System.in);
	Product p = new Product();
	List<Product> products = new ArrayList<Product>();
	
	public void displayAdminGreeting(){
		System.out.println("------------------------------------------------------------");
		System.out.println("|              Welcome to Admin Page                        |");
		System.out.println("------------------------------------------------------------");
		System.out.println("");
	}
	public void adminControls(){
		System.out.println("Enter a choice: ");
		System.out.println("1. Add product");
		System.out.println("2. Update product");
		System.out.println("3. Delete product");
		System.out.println("4. Display product");
		System.out.println("5. Display all product");
		System.out.println("6. Back menu");
		System.out.println("");
		
		int choice = sc.nextInt();
		switch(choice){
		case 1:	System.out.println("Adding new product");
				System.out.println("Enter the product ID: ");
				p.setPid(sc.nextInt());
				System.out.println("Enter the product name: ");
				p.setpName(sc.next());
				System.out.println("Enter the product price: ");
				p.setPrice(sc.nextDouble());
				ad.addProduct(p);
				break;
		case 2: System.out.println("Updating product");
				System.out.println("Enter the product ID of product you wish to update: ");
				ad.updateProduct(sc.nextInt());
				break;
		case 3: System.out.println("Deleting product");
				System.out.println("Enter the product ID of product you wish to delete: ");
				ad.deleteProduct(sc.nextInt());
				break;
		case 4: System.out.println("Displaying product");
				System.out.println("Enter the product ID of product you wish to display: ");
				p = ad.displayProduct(sc.nextInt());
				System.out.println("The product is displayed below");
				if(p.getPid() == 0){
					System.out.println("There are no products to display");
				}else{
				System.out.println(p.toString());
				}
				break;
		case 5: System.out.println("Displaying all products");
				products = ad.displayAllProduct();
				System.out.println("The products are displayed below");
				//Product pr = new Product();
				//System.out.println(Arrays.toString(products.toArray()));
				//for (int i = 0; i < products.size(); i++){
				//	System.out.println(products.get(i));
				//}
				for (Product p : products){
					System.out.println(p);
				}
				break;
		case 6: System.out.println("Going back to Main Menu");
				ad.Back();
				break;
				
		}
	}
	
	
	
}
