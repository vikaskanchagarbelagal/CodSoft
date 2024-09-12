package Intern;

import java.util.Scanner;

class UserBankAccount {
	int ano;
	String name;
	float balance;
	UserBankAccount(int p1, String p2, float p3) {
		ano = p1;
		name = p2;
		balance = p3;
	}
	void deposit(int da) {
		balance = balance + da;
		System.out.println("The amout has been deposited sucessfully");
		System.out.println("Your current balance amount is: " + balance);
	}
	void withdraw(int wa) {
		if(wa > balance) {
			System.out.println("Insufficient Balance");
			return;
		}
		balance = balance - wa;
		System.out.println("The amout has been withdrawn sucessfully");
		System.out.println("Your current balance amount is: " + balance);
	}
	void checkBalance() {
		System.out.println("The balance amount is : " + balance);
	}
}
public class ATM {

	public static void main(String[] args) {
		UserBankAccount uba = new UserBankAccount(12345, "Basavaraj", 500.00f);
		Scanner sc = new Scanner(System.in);
		for(;;) {
			System.out.println("-----ATM MENU------");
			System.out.println("1-Deposit\n2-Withdrawal\n3-Balance Check\n4-Logout");
			System.out.print("Enter your option: ");
			int op = sc.nextInt();
			switch(op) {
				case 1: System.out.print("Enter the amount to be depoisted: ");
						int da = sc.nextInt();
						uba.deposit(da);
						break;
				case 2: System.out.print("Enter the amount to be withdrawn: ");
						int wa = sc.nextInt();
						uba.withdraw(wa);
						break;
				case 3: uba.checkBalance();
						break;
				case 4: System.exit(0);
			}
		}
	}
}