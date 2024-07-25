package packageOne;

import java.util.Scanner;

public class Email {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int defaultPassLength = 10;
	private String department;
	private int mailBoxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "newComp.com";
	
	//Constructor to receive the firstName and lastName
	public Email(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		
		//call a method asking for a department and return the department
		this.department = setDepartment();
		
		//call a method that returns a random password
		this.password = randomPassword(defaultPassLength);
		
		//Combine elements to create email
		if(this.department.length() == 0) {
			this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.companySuffix;
		}else {
			this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department + "." + this.companySuffix;
		}
		
	}
	
	//Ask for the department
	private String setDepartment() {
		System.out.println("SELECT A DEPARTMENT CODE...\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
		try(Scanner scanner = new Scanner(System.in)){
			int deptChoice = scanner.nextInt();
			if(deptChoice == 1) {
				setMailboxCapacity(700);
				return "sales";}
			else if(deptChoice == 2) {
				setMailboxCapacity(300);
				return "developement";}
			else if(deptChoice == 3) {
				setMailboxCapacity(400);
				return "accounting";}
			else {return "";}	
		}
	}
	
	
	//Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$€%";
		char[] password = new char[length];
		for(int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password); //like this 'cus password is set of char, so to get a proper string used String instance.
	}
	
	//Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {this.mailBoxCapacity = capacity;}
	
	//Set the alternate email
	public void setAlternateEmail(String altEmail) {this.alternateEmail = altEmail;}
	
	//Change the password
	public void changePassword(String password) {this.password = password;}
	
	public int getMailboxCapacity() {return this.mailBoxCapacity;}
	public String getAlternateEmail() {return this.alternateEmail;}
	public String getPassword() {return this.password;}
	
	public String showInfo() {
		return "DISPLAY NAME: " + this.firstName + " " + this.lastName + "\n" +
				"COMPANY EMAIL: " + this.email + "\n" +
				"DEFAULT PASSWORD: " + this.password + "\n" +
				"MAILBOX CAPACITY: " + this.mailBoxCapacity + "mb";
	}
}
