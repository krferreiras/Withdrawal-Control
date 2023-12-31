
package com.fixingExercise.model.entities;

import com.fixingExercise.model.exceptions.BusinessException;

public class Account {
	
	private Integer numberAccount;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		
	}

	public Account(Integer numberAccount, String holder, Double balance, Double withdrawLimit) {
		this.numberAccount = numberAccount;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(Integer numberAccount) {
		this.numberAccount = numberAccount;
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

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit (Double amount) {
		this.balance += amount;
	}
	
	public void withdraw (Double amount) {
		validateWithdraw(amount);
		this.balance -= amount;
	}
	
	private void validateWithdraw (Double amount) {
		if(amount > getWithdrawLimit()) {
			throw new BusinessException("Erro de saque: A quantia excede o limite de saque.");
		}
		if (amount > getBalance()){
			throw new BusinessException("Erro de saque: Saldo insuficiente.");
		}
	}
}
