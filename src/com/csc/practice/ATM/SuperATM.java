/**
 * 
 */
package com.csc.practice.ATM;

import com.csc.practice.ATM.Interface.Depositable;
import com.csc.practice.ATM.Interface.PassbookUpdatable;
import com.csc.practice.Bank.Bank;

import Exception.NotLoginException;

/**
 * @author 189993
 *
 */
public class SuperATM extends BaseATM implements Depositable, PassbookUpdatable {

	public SuperATM(ATMType type, Bank bank, int initialMoney) {
		super(type, bank, initialMoney);
		MAX_MONEY = 100000000;
	}

	@Override
	public void passBookUpdate()throws NotLoginException {
		if (super.isLogin) {
			currentAccount.updatePassbookTimes();
		}
		else{
			throw new NotLoginException();
		}
	}

	@Override
	public void deposit(int money) {
		// TODO Auto-generated method stub
	}

}
