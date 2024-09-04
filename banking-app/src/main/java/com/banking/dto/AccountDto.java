package com.banking.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class AccountDto {
	
	private long id;
	private String accountHolderName;
	private double balance;
	
	
	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDto(long id, String account_holder_name, double balance) {
		super();
		this.id = id;
		this.accountHolderName = account_holder_name;
		this.balance = balance;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccount_holder_name(String account_holder_name) {
		this.accountHolderName = account_holder_name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "AccountDto [id=" + id + ", account_holder_name=" + accountHolderName + ", balance=" + balance + "]";
	}

}	
