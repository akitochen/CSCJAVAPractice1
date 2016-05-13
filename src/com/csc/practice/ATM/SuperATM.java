/**
 * 
 */
package com.csc.practice.ATM;

import com.csc.practice.ATM.Interface.Depositable;
import com.csc.practice.ATM.Interface.PassbookUpdatable;
import com.csc.practice.Bank.Bank;

/**
 * @author 189993
 *
 */
public class SuperATM  extends BaseATM implements Depositable, PassbookUpdatable{

	public SuperATM(ATMType type, Bank bank, int initialMoney) {
		super(type, bank, initialMoney);
		MAX_MONEY = 100000000;
	}

	@Override
	public boolean passBookUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deposit(int money) {
		// TODO Auto-generated method stub
	}

}
