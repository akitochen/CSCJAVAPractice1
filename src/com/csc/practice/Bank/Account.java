/**
 * 
 */
package com.csc.practice.Bank;

import com.csc.practice.ATM.Interface.Depositable;
import com.csc.practice.ATM.Interface.WithDrawable;

import Exception.InsufficientMoneyException;
import Exception.InsufficientMoneyType;
import Exception.NotLoginException;
import Exception.OutOfPassbookUpdateTimesException;

/**
 * @author 189993
 *
 */
public class Account implements WithDrawable, Depositable{
	private final int MAX_PASSBOOK_TIMES = 20;
	private String cardId;
	private String name;
	private String password;
	private int passbookTimes;
	private int deposit;
	private boolean isLogin = false;

	public Account(String cardId, String name, String password, int deposit) {
		this.cardId = cardId;
		this.name = name;
		this.password = password;
		this.deposit = deposit;
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

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	// method
	public void updatePassBook() {
		this.passbookTimes = MAX_PASSBOOK_TIMES;
	}

	public boolean isOverUpdatePassbookTimes() {
		if (this.passbookTimes == 0)
			return true;
		else
			return false;
	}

	public boolean verifyCardId() {
		return false;
	}

	public boolean verifyPassword() {
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("CardId : %s , Name : %s , Password : %s , deposit : %d", cardId, name, password, deposit);
	}

	@Override
	public void deposit(int depositMoney) throws NotLoginException{
		if(this.isLogin){
			this.deposit += depositMoney;
		}
		else{
			throw new NotLoginException();
		}
	}

	@Override
	public int withDraw(int withDrawMoney)throws NotLoginException, OutOfPassbookUpdateTimesException, InsufficientMoneyException {
		if(!isLogin){
			throw new NotLoginException();
		}
		
		if(!isOverUpdatePassbookTimes()){
			throw new OutOfPassbookUpdateTimesException(this, MAX_PASSBOOK_TIMES);
		}
		
		if(withDrawMoney > this.deposit){
			throw new InsufficientMoneyException(InsufficientMoneyType.Account, this, withDrawMoney, this.deposit);
		}
		
		this.deposit -= withDrawMoney;
		this.passbookTimes++;
		
		return withDrawMoney;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
}
