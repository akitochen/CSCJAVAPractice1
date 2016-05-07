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
	
	public SmallATM(Bank bank) {
		super(bank);
		MAX_MONEY = 10000000;
	}
	
}
