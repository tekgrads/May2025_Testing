//Write a class BankAccount that allows deposit and withdrawal from multiple threads. Ensure data consistency using synchronized blocks or methods.
package com.tekgrads.multithreading;
//BankAccount class with synchronized methods
class BankAccount {
 private int balance = 0;

 public synchronized void deposit(int amount) {
     balance = balance+amount;
     System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", Balance: " + balance);
 }

 public synchronized void withdraw(int amount) {
     if (balance >= amount) {
         balance = balance- amount;
         System.out.println(Thread.currentThread().getName() + " withdrawing " + amount + ", Balance: " + balance);
     } else {
         System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but insufficient balance: " + balance);
     }
 }

 public synchronized int getBalance() {
     return balance;
 }
}

//Deposit task implementing Runnable
class Deposit implements Runnable {
 private BankAccount account;

 public Deposit(BankAccount account) {
     this.account = account;
 }

 public void run() {
     account.deposit(1000);
     account.deposit(400);
 }
}

//Withdraw task implementing Runnable
class Withdraw implements Runnable {
 private BankAccount account;

 public Withdraw(BankAccount account) {
     this.account = account;
 }

 public void run() {
     account.withdraw(500);
     account.withdraw(1000);
 }
}

//Main class
public class BankAccountSynchronized {
 public static void main(String[] args) {
     BankAccount account = new BankAccount();

     Deposit d = new Deposit(account);
     Withdraw w = new Withdraw(account);

     Thread t1 = new Thread(d, "Depositor");
     Thread t2 = new Thread(w, "Withdrawer");

     t1.start();
     t2.start();
 }
}