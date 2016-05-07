/**
 * 
 */
package com.csc.practice.ATM;

import com.csc.practice.ATM.Interface.Depositable;
import com.csc.practice.Bank.Bank;

/**
 * @author 189993
 *
 */
public class CityATM extends BaseATM implements Depositable{

	public CityATM(Bank bank) {
		super(bank);
		MAX_MONEY = 50000000;
	}

	@Override
	public int deposit(int money) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
