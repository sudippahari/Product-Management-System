package com.sudip.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sudip.DAO.AdminDAO;
import com.sudip.db.ConnectionManager;
import com.sudip.home.HomePage;
import com.sudip.product.Product;

public class AdminDAOImpl implements AdminDAO {
	
	ConnectionManager connect = new ConnectionManager();
	Connection con = ConnectionManager.getConnection();
	Scanner sc = new Scanner(System.in);
	Product p;
	HomePage hp = new HomePage();
	//List<Product> products = new ArrayList<Product>();
	
	public void addProduct(Product p){
		try {
			PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?)");
			ps.setInt(1, p.getPid());
			ps.setString(2, p.getpName());
			ps.setDouble(3, p.getPrice());
			int n = ps.executeUpdate();
			if (n != 0){
				System.out.println("Product successfully added");
			}else{
				System.out.println("Unable to add product");
			}
			ps.close();
			//con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateProduct(int pid){
		
			System.out.println("For product with pid = " + pid);
			System.out.println("What do you wish to update? ");
			System.out.println("Choice 1: Product name ");
			System.out.println("Choice 2: Product price ");
			System.out.println("Choice 3: Product name and price ");
			int choice = sc.nextInt();
			
			if(choice == 1){
				try {
					PreparedStatement ps = con.prepareStatement("update product set pName = ? where pid = ?");
					System.out.println("Enter the new name: ");
					ps.setString(1, sc.next());
					ps.setInt(2, pid);
					int n = ps.executeUpdate();
					if (n != 0){
						System.out.println("Product name sucessufully updated");
					}else{
						System.out.println("Unable to update product name. Try again.");
					}
					ps.close();
					//con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if (choice == 2){
				try {
					PreparedStatement ps = con.prepareStatement("update product set price = ? where pid = ?");
					System.out.println("Enter the new price: ");
					ps.setDouble(1, sc.nextDouble());;
					ps.setInt(2, pid);
					int n = ps.executeUpdate();
					if (n != 0){
						System.out.println("Product price sucessufully updated");
					}else{
						System.out.println("Unable to update product price. Try again.");
					}
					ps.close();
					//con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if (choice == 3){
				try {
					PreparedStatement ps = con.prepareStatement("update product set pName = ?,price = ? where pid = ?");
					System.out.println("Enter the new name: ");
					ps.setString(1, sc.next());
					System.out.println("Enter the new price: ");
					ps.setDouble(2, sc.nextDouble());
					ps.setInt(3, pid);
					int n = ps.executeUpdate();
					if (n != 0){
						System.out.println("Product name and price sucessufully updated");
					}else{
						System.out.println("Unable to update product name or price. Try again.");
					}
					ps.close();
					//con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else{
				System.out.println("Invalid choice. Exiting now");
				System.exit(1);
			}
							
	}
		
	public void deleteProduct(int pid){
		System.out.println("For product with pid = " + pid);
		try {
			PreparedStatement ps = con.prepareStatement("delete from product where pid = ?");
			ps.setInt(1, pid);
			int n = ps.executeUpdate();
			if (n != 0){
				System.out.println("Product successfully deleted");
			}else{
				System.out.println("Unable to delete product");
			}
			ps.close();
			//con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Product displayProduct(int pid){
		System.out.println("For product with pid = " + pid);
		p = new Product();
		try {
			PreparedStatement ps = con.prepareStatement("select * from product where pid = ?");
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery();
			//ResultSetMetaData rsmd = rs.getMetaData();
			//System.out.println(rsmd.getColumnName(1) + "\t" + rsmd.getColumnName(2) + "\t" + rsmd.getColumnName(3));
			while(rs.next()){
				//System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
				p.setPid(rs.getInt(1));
				p.setpName(rs.getString(2));
				p.setPrice(rs.getDouble(3));
			}
			ps.close();
			//con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
		
	}
	public List<Product> displayAllProduct(){
		List<Product> products = new ArrayList<Product>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from product");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				p = new Product();
				//System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
				p.setPid(rs.getInt(1));
				p.setpName(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				products.add(p);
				//products.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}
			ps.close();
			//con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	public void Back(){
		hp.execute();
	}


}
