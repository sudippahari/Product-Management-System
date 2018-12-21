package com.sudip.home;

import java.util.Scanner;

public class HomePage {

	public void execute(){
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("|              Welcome to Product Management System                        |");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("");
		
		Scanner sc = new Scanner(System.in);
		Admin a = new Admin();
		User u = new User();
		
		
		
		String yesNoChoice = "";
		
		
		do{
			System.out.println("What would you like to do: ");
			System.out.println("1. Login to Admin page");
			System.out.println("2. Login to User page ");
			System.out.println("3. Exit ");
			int choice = sc.nextInt();	
			switch(choice){
			case 1: System.out.println("Enter admin password:");
					String str = "";
					do{	str = sc.next();
						if(str.equals("admin")){
							a.displayAdminGreeting();
							a.adminControls();
					}else{
						System.out.println("Incorrect password. Try again:");
						
					}
						}while(!(str.equals("admin")));
					break;
					
			case 2: u.displayUserGreeting();
					u.userControls();
					break;
					
			case 3: System.exit(-1);
			}
			System.out.println("\nDo you wish to continue(Y/N):");
			yesNoChoice = sc.next();
		}while(!((yesNoChoice.equals("N")) || (yesNoChoice.equals("n"))));			
		sc.close();

	}

	public static void main(String[] args) {

		HomePage hp = new HomePage();
		hp.execute();
	}

}
