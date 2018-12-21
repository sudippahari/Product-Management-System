package com.sudip.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sudip.DAO.UserDAO;
import com.sudip.db.ConnectionManager;
import com.sudip.home.HomePage;
import com.sudip.product.Product;

public class UserDAOImpl implements UserDAO {

	ConnectionManager connect = new ConnectionManager();
	Connection con = ConnectionManager.getConnection();
	Scanner sc = new Scanner(System.in);
	HomePage hp = new HomePage();
	Product p = null;
	public Product displayProduct(int pid){
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
