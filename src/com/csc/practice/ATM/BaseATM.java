/**
 * 
 */
package com.csc.practice.ATM;

import com.csc.practice.ATM.Interface.Queryable;
import com.csc.practice.ATM.Interface.WithDrawable;
import com.csc.practice.Bank.Account;
import com.csc.practice.Bank.Bank;

import Exception.AccountNotFoundException;
import Exception.InsufficientBalanceException;
import Exception.InsufficientMoneyException;
import Exception.InsufficientMoneyType;
import Exception.NotLoginException;
import Exception.OutOfPassbookUpdateTimesException;
import Exception.OvercapacityException;
import Exception.OvercapacityType;
import Exception.PasswordException;

/**
 * @author 189993
 *
 */
public class BaseATM extends AbstractATM implements WithDrawable, Queryable {
	protected int atmNumber;
	protected ATMType myAtmType;
	protected Bank ownerBank = null;
	protected int remainMoney = 0;
	protected boolean isLogin = false;
	protected Account currentAccount = null;

	public BaseATM(ATMType type, Bank bank, int initialMoney) {
		super.ONE_TIME_WITHDRAW_MONEY_LIMIT = 3000000;
		this.myAtmType = type;
		this.ownerBank = bank;
		this.remainMoney = initialMoney;
	}

	public void setAtmNumber(int number) {
		atmNumber = number;
	}
	
	public int getAtmNumber() {
		return atmNumber;
	}

	public ATMType geAtmType(){
		return this.myAtmType;
	}
	
	public int getRemainMoney(){
		return this.remainMoney;
	}

	@Override
	public boolean login(String carId, String password) throws AccountNotFoundException, PasswordException {
		if (ownerBank.isAccountExists(carId)) {
			Account account = ownerBank.getAccount(carId);
			if (password != null && password.equals(account.getPassword())) {
				isLogin = true;
				currentAccount = account;
				currentAccount.setLogin(true);
				return true;
			} else {
				throw new PasswordException(account);
			}
		} else {
			throw new AccountNotFoundException(carId);
		}
	}

	@Override
	public void logout() {
		isLogin = false;
		currentAccount = null;
	}

	@Override
	public int withDraw(int withdrawMoney) throws NotLoginException, InsufficientBalanceException,
			InsufficientMoneyException, OutOfPassbookUpdateTimesException {
		if (!isLogin) {
			throw new NotLoginException();
		}

		if (currentAccount.isOverUpdatePassbookTimes()) {
			throw new OutOfPassbookUpdateTimesException(currentAccount, Account.MAX_PASSBOOK_TIMES);
		}

		if (withdrawMoney > ONE_TIME_WITHDRAW_MONEY_LIMIT) {
			throw new InsufficientBalanceException(currentAccount, withdrawMoney, super.ONE_TIME_WITHDRAW_MONEY_LIMIT);
		}

		if (withdrawMoney > remainMoney) {
			throw new InsufficientMoneyException(InsufficientMoneyType.ATM, currentAccount, withdrawMoney, remainMoney);
		}

		int getMoney = currentAccount.withDraw(withdrawMoney);
		remainMoney -= getMoney;

		return getMoney;
	}

	@Override
	public int query() throws NotLoginException {
		if (isLogin) {
			return currentAccount.getDeposit();
		} else {
			throw new NotLoginException();
		}
	}

	@Override
	public int queryAll() {
		return remainMoney;
	}

	@Override
	public void putMoney(int money)throws OvercapacityException {
		if (this.remainMoney + money > super.MAX_MONEY) {
			throw new OvercapacityException(OvercapacityType.Bank, currentAccount, money, this.remainMoney, super.MAX_MONEY);
		} else {
			int moneyFromBank = ownerBank.getMoney(money);
			this.remainMoney += moneyFromBank;
		}
	}

	
	@Override
	public String toString() {
		return "BaseATM [atmNumber=" + atmNumber + ", myAtmType=" + myAtmType + ", remainMoney=" + remainMoney + "]";
	}


}
