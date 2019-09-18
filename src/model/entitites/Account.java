package model.entitites;

import model.exception.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public String getHolder() {
		return holder;
	}


	public void setHolder(String holder) {
		this.holder = holder;
	}


	public Double getBalance() {
		return balance;
	}


	public void deposit(Double deposit) {
		balance += deposit;		
	}
	
	public void withdraw(Double withdraw) throws DomainException {
		if(withdraw > withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit!");
		}
		if(balance == 0) {
			throw new DomainException("There is no balance in this account!");
		}
		if(withdraw > balance) {
			throw new DomainException("Withdrawn cannot be higher than balance!");
		}
		balance -= withdraw;
	}
	
	
	
}
