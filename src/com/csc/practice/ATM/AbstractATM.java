/**
 * 
 */
package com.csc.practice.ATM;

import Exception.AccountNotFoundException;
import Exception.OvercapacityException;
import Exception.PasswordException;

/**
 * @author 189993
 *
 */
public abstract class AbstractATM {
	protected ATMType myATMType;
	protected int MAX_MONEY;
	protected int ONE_TIME_WITHDRAW_MONEY_LIMIT;
	public abstract void putMoney(int money)throws OvercapacityException;
	public abstract boolean login(String carId, String password)throws AccountNotFoundException, PasswordException;
	public abstract void logout();
}
