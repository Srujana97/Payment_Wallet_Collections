package com.cg.pp.service;

import java.util.List;

import com.cg.pp.dao.WalletApplicationDao;
import com.cg.pp.dto.WalletApplicationData;


public class WalletApplicationService implements  IWalletApplicationService{
	WalletApplicationDao dao = new WalletApplicationDao();
	
	
	public int createAccount(WalletApplicationData bean) {
		return dao.createAccount(bean);
	}

	public boolean login(String username, String password) {
		return dao.login(username, password);
	}

	public double showBalance() {
		return dao.showBalance();
	}

	public int deposit(double amount) {
		return dao.deposit(amount);
	}

	public int withdraw(double amount) {
		return dao.withdraw(amount);
	}

	public int fundTransfer(long accNo, double amount) {
		return dao.fundTransfer(accNo, amount);
	}
	
	public List printTransaction() {
		return dao.printTransaction();
	}
}
