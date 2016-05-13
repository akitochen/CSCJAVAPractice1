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
import Exception.PasswordException;

/**
 * @author 189993
 *
 */
public class BaseATM extends AbstractATM implements WithDrawable, Queryable {
	protected ATMType myATMType = null;
	protected Bank ownerBank = null;
	protected int remainMoney = 0;
	protected boolean isLogin = false;
	protected Account currentAccount = null;

	public BaseATM(ATMType type, Bank bank, int initialMoney) {
		this.myATMType = type;
		this.ownerBank = bank;
		this.remainMoney = initialMoney;
		checkMoney();
		super.ONE_TIME_WITHDRAW_MONEY_LIMIT = 3000000;
	}

	private void checkMoney() {
		if (remainMoney > super.MAX_MONEY) {
			// throw Exception
		}
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
				throw new PasswordException(currentAccount);
			}
		} else {
			throw new AccountNotFoundException(currentAccount);
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

		if (withdrawMoney > ONE_TIME_WITHDRAW_MONEY_LIMIT) {
			throw new InsufficientBalanceException(currentAccount, withdrawMoney, super.ONE_TIME_WITHDRAW_MONEY_LIMIT);
		}

		if (withdrawMoney > remainMoney) {
			throw new InsufficientMoneyException(InsufficientMoneyType.ATM, currentAccount, withdrawMoney,
					remainMoney);
		}

		int getMoney = currentAccount.withDraw(withdrawMoney);
		remainMoney -= getMoney;

		return getMoney;
	}

	@Override
	public int query()throws NotLoginException{
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
	public boolean putMoney() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return String.format("ATM type : %s , money : %d", myATMType.toString(), remainMoney);
	}

}
