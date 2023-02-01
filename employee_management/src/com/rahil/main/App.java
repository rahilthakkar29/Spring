package com.rahil.main;

import java.util.Scanner;

import com.rahil.CRUD.CreateEmployee;
import com.rahil.CRUD.DeleteById;
import com.rahil.CRUD.ReadByCompany;
import com.rahil.CRUD.ReadById;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("------------Welcome to Employee Management System------------");
		boolean loop = true;
		int option;
		while(loop) {
			System.out.println("Select from the following options");
			System.out.println("1. Craete an employee\n"
					+ "2. Read by employee id\n"
					+ "3. Read by company name\n"
					+ "4.Delete an employee\n"
					+ "5. Exit\n\n");
			System.out.print("Enter your option:: ");
			option = sc.nextInt();
			sc.nextLine();
		
			switch(option) {
			
				case 1:
					System.out.print("Enter the first name:: ");
					String firstName = sc.nextLine();
					System.out.print("Enter the last name:: ");
					String lastName = sc.nextLine();
					System.out.print("Enter the company name:: ");
					String company = sc.nextLine();
					CreateEmployee employee = new CreateEmployee();
					employee.create(firstName, lastName, company);
					break;
					
				case 2:
					System.out.print("Enter employee id:: ");
					int id = sc.nextInt();
					ReadById byId = new ReadById();
					byId.read(id);
					break;
					
				case 3:
					System.out.print("Enter the company name:: ");
					String company1 = sc.nextLine();
					ReadByCompany readByCompany = new ReadByCompany();
					readByCompany.read(company1);
					break;
					
				case 4:
					System.out.print("Enter the id:: ");
					int id1 = sc.nextInt();
					DeleteById deleteById = new DeleteById();
					deleteById.delete(id1);
					break;
					
				case 5:
					loop = false;
					System.out.println("Bye!");
					break;
					
				default:
					System.out.println("Please enter a valid input");
			
			}
		}
		sc.close();
	}
	
}
