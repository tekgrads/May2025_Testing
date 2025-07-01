import java.util.Scanner;

class BankAccount {
long accNum;
String accHName;
double balance;

void readDetails(Scanner scanner) {
System.out.print("Enter Account Number: ");
accNum = scanner.nextLong();
scanner.nextLine();

System.out.print("Enter Account Holder Name: ");
accHName = scanner.nextLine();

System.out.print("Enter Initial Balance: ");
balance = scanner.nextDouble();
}

void deposit(double amount) {
if (amount > 0) {
balance += amount;
System.out.println("Deposited: ₹" + amount);
} else {
System.out.println("Invalid deposit amount.");
}
}

void withdraw(double amount) {
if (amount > 0 && amount <= balance) {
balance -= amount;
System.out.println("Withdrawn: ₹" + amount);
} else {
System.out.println("Insufficient balance or invalid amount.");
}
}

void currentBalance() {
System.out.println("Current Balance: ₹" + balance);
}

void display() {
System.out.println("\n--- Account Details ---");
System.out.println("Account Number      : " + accNum);
System.out.println("Account Holder Name : " + accHName);
System.out.println("Balance             : ₹" + balance);
}
}
