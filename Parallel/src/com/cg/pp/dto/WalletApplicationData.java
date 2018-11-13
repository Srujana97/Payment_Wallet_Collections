package com.cg.pp.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WalletApplicationData {
	
	private long accNo;
	private LocalDate date;
	private String branch;
	private String ifsc;
	private double amount;
	private long tid;
	private Customer customer;
	
	static List<String> transaction = new ArrayList<String>();
	
	public static List<String> getTransaction() {
		return transaction;
	}
	public static void setTransaction(List<String> transaction) {
		WalletApplicationData.transaction = transaction;
	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "WalletApplicationData [accNo=" + accNo + ",   date="
				+ date + ", branch=" + branch + ", ifsc=" + ifsc + ", amount=" + amount + ", tid=" + tid + ", customer="
				+ customer + "]";
	}
	
}
