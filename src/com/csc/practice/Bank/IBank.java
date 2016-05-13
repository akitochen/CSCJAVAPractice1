/**
 * 
 */
package com.csc.practice.Bank;

import com.csc.practice.ATM.ATMType;
import com.csc.practice.ATM.BaseATM;

/**
 * @author 189993
 *
 */
public interface IBank {
	boolean isAccountExists(String cardId);
	int sumOfAtm();
	BaseATM addATM(ATMType atmType, int initialMoney);
	Account addAccount(String cardId, String name, String password, int deposit);
	Account getAccount(String cardId);
}
