/**
 * 
 */
package com.csc.practice.ATM;

import com.csc.practice.ATM.Interface.Depositable;
import com.csc.practice.Bank.Bank;

import Exception.NotLoginException;
import Exception.OvercapacityException;
import Exception.OvercapacityType;

/**
 * @author 189993
 *
 */
public class CityATM extends BaseATM implements Depositable {

	public CityATM(ATMType type, Bank bank, int initialMoney) {
		super(type, bank, initialMoney);
		MAX_MONEY = 50000000;
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
