/**
 * 
 */
package com.csc.practice.Bank;

import com.csc.practice.ATM.Interface.Depositable;
import com.csc.practice.ATM.Interface.WithDrawable;

import Exception.InsufficientMoneyException;
import Exception.InsufficientMoneyType;
import Exception.NotLoginException;

/**
 * @author 189993
 *
 */
public class Account implements WithDrawable, Depositable {
	public static final int MAX_PASSBOOK_TIMES = 20;
	private String cardId;
	private String name;
	private String password;
	private int passbookTimes;
	private int deposit;
	private boolean isLogin = false;
	private int bankId;

	public Account(String cardId, String name, String password, int deposit) {
		this.cardId = cardId;
		this.name = name;
		this.password = password;
		this.deposit = deposit;
		this.passbookTimes = Account.MAX_PASSBOOK_TIMES;
	}

	// properties
	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPassbookTimes() {
		return passbookTimes;
	}

	public void setPassbookTimes(int passbookTimes) {
		this.passbookTimes = passbookTimes;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	// method
	public void updatePassbookTimes() {
		this.passbookTimes = Account.MAX_PASSBOOK_TIMES;
	}

	public boolean isOverUpdatePassbookTimes() {
		if (this.passbookTimes == 0)
			return true;
		else
			return false;
	}

	public boolean verifyCardId(String cardId) {
		if (cardId != null && this.cardId.equals(cardId)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyPassword(String password) {
		if (password != null && this.password.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void deposit(int depositMoney) throws NotLoginException {
		if (this.isLogin) {
			this.deposit += depositMoney;
		} else {
			throw new NotLoginException();
		}
	}

	@Override
	public int withDraw(int withDrawMoney) throws NotLoginException, InsufficientMoneyException {
		if (!isLogin) {
			throw new NotLoginException();
		}

		if (withDrawMoney > this.deposit) {
			throw new InsufficientMoneyException(InsufficientMoneyType.Account, this, withDrawMoney, this.deposit);
		}

		this.deposit -= withDrawMoney;
		this.passbookTimes--;

		return withDrawMoney;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	
	@Override
	public String toString() {
		return "Account [cardId=" + cardId + ", name=" + name + ", password=" + password + ", passbookTimes="
				+ passbookTimes + ", deposit=" + deposit + "]";
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
}
