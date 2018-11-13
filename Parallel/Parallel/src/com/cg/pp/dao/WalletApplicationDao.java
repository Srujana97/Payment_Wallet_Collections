package com.cg.pp.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cg.pp.dto.WalletApplicationData;


public class WalletApplicationDao implements IWalletApplicationDao {
	static List<WalletApplicationData> list = new ArrayList<WalletApplicationData>();
	static WalletApplicationData temp = new WalletApplicationData();
	
	long tid = 0;
	
	public int createAccount(WalletApplicationData bean) {
		
		boolean b = list.add(bean);
		if(b)
			return 1;
		return 0;
	}

	public boolean login(String username, String password) {
		
		Iterator<WalletApplicationData> it = list.iterator();
		while(it.hasNext()) {
			WalletApplicationData credentials = it.next();
			if(credentials.getCustomer().getUserName().equals(username) && credentials.getCustomer().getPassword().equals(password)) {
				temp = (credentials);
				return true;
			}
			
		}
		
		return false;
	}

	public double showBalance() {
		return temp.getAmount();
	}

	public int deposit(double amount) {
		
		Iterator<WalletApplicationData> it = list.iterator();
	//	WalletApplicationData wallet = it.next();
		while(it.hasNext()) {
			WalletApplicationData wallet = it.next();
			if(temp.getCustomer().getUserName().equals(wallet.getCustomer().getUserName()) && temp.getCustomer().getPassword().equals(wallet.getCustomer().getPassword())) {
				double bal = wallet.getAmount()+amount;
				System.out.println(bal);
				wallet.setAmount(bal);
			}
		
		}
		
		System.out.println("amount deposited.  Current balance in your account "+temp.getAmount());
		return 0;
	}

	public int withdraw(double amount) {
		Iterator<WalletApplicationData> it = list.iterator();
		while(it.hasNext()) {
			WalletApplicationData wallet = it.next();
			if(temp.getCustomer().getUserName().equals(wallet.getCustomer().getUserName())) {
				if(amount < wallet.getAmount()) {
				tid = (long)(Math.random()*1234 +9999);
				double balance = wallet.getAmount()-amount;
				wallet.setAmount(balance);
				LocalDateTime d = LocalDateTime.now();
				String s = "TransactionId "+Long.toString(tid)+" at "+d.toString()+" and withdrawn amount "+Double.toString(amount);
				temp.getTransaction().add(s);
			  
				System.out.println("Your account is debited with" +amount+","+"Current balance is " +balance);
				return 1;
				}
				else {
					System.out.println("In-sufficient amount");
				}
			}
			
			
		}
		
		
		return 0;
		
		
		}

	public int fundTransfer(long accNo, double amount) {
		
		System.out.println("1234");
		
		Iterator<WalletApplicationData> it = list.iterator();
		Iterator<WalletApplicationData> it1 = list.iterator();
		/*while(!it.hasNext()) {
			
			
			if(temp.getCustomer().getUserName().equals(wallet.getCustomer().getUserName())) {*/
				while(it1.hasNext()) {
					WalletApplicationData wallet = it.next();
					WalletApplicationData wallet1 = it1.next();
					if(wallet1.getAccNo() == accNo) {
						if(amount < wallet.getAmount()) {
					
				
				tid = (long)(Math.random()*1234 + 9999);
				
				double balance = wallet.getAmount() - amount;
				wallet.setAmount(balance);
				
			    double bal = wallet1.getAmount() + amount;
			    wallet1.setAmount(bal);
			    
				LocalDateTime d = LocalDateTime.now();
				String s = "TransactionId "+Long.toString(tid)+" at "+d.toString()+" and transferred amount  "+Double.toString(amount);
				temp.getTransaction().add(s);
				System.out.println("amount " +amount+","+" is transferred to account number" + accNo);
				return 1;
				}
						else {
							System.out.println("No sufficient balance");
						}
						}}
			//}
			//}
			return 0;
			
			
		
	}
	
	public List printTransaction() {
		Iterator<WalletApplicationData> it = list.iterator();
		while(it.hasNext()) {
			WalletApplicationData trans = it.next();
			if(temp.getCustomer().getUserName().equals(trans.getCustomer().getUserName())) {
			System.out.println(trans.getTransaction());
		
		}}
		return null;
	}

}
