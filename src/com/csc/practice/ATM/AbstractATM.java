/**
 * 
 */
package com.csc.practice.ATM;

import Exception.AccountNotFoundException;
import Exception.PasswordException;

/**
 * @author 189993
 *
 */
public abstract class AbstractATM {
	public int MAX_MONEY;
	public int ONE_TIME_WITHDRAW_MONEY_LIMIT;
	public abstract boolean putMoney();
	public abstract boolean login(String carId, String password)throws AccountNotFoundException, PasswordException;
	public abstract void logout();
}
