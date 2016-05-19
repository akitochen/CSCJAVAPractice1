/**
 * 
 */
package com.csc.practice.ATM;

import com.csc.practice.ATM.Interface.Depositable;
import com.csc.practice.ATM.Interface.PassbookUpdatable;
import com.csc.practice.Bank.Bank;

import Exception.NotLoginException;
import Exception.OvercapacityException;
import Exception.OvercapacityType;

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
	public void deposit(int depositMoney) throws NotLoginException, OvercapacityException {
		if (super.isLogin) {
			// 要檢查ATM存款上限
			if (super.remainMoney + depositMoney > MAX_MONEY) {
				throw new OvercapacityException(OvercapacityType.Account, super.currentAccount, depositMoney, super.remainMoney, MAX_MONEY);
			} else {
				super.remainMoney += depositMoney;
				super.currentAccount.deposit(depositMoney);
			}
		} else {
			throw new NotLoginException();
		}
	}

}
