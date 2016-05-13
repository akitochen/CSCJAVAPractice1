/**
 * 
 */
package com.csc.practice.ATM;

import com.csc.practice.Bank.Bank;

/**
 * @author 189993
 *
 */
public class SmallATM  extends BaseATM {
	
	public SmallATM(ATMType type, Bank bank, int initialMoney) {
		super(type, bank, initialMoney);
		MAX_MONEY = 10000000;
	}
	
}
