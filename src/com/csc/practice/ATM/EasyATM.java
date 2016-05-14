/**
 * 
 */
package com.csc.practice.ATM;

import com.csc.practice.ATM.Interface.PassbookUpdatable;
import com.csc.practice.Bank.Bank;

import Exception.NotLoginException;

/**
 * @author 189993
 *
 */
public class EasyATM  extends BaseATM implements PassbookUpdatable{

	public EasyATM(ATMType type, Bank bank, int initialMoney) {
		super(type, bank, initialMoney);
		MAX_MONEY = 30000000;
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

}
