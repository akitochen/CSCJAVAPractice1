/**
 * 
 */
package com.csc.practice.ATM;

import com.csc.practice.ATM.Interface.PassbookUpdatable;
import com.csc.practice.Bank.Bank;

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
	public boolean passBookUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

}
