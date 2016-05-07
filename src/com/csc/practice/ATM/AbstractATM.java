/**
 * 
 */
package com.csc.practice.ATM;

/**
 * @author 189993
 *
 */
public abstract class AbstractATM {
	public int MAX_MONEY;
	public abstract boolean putMoney();
	public abstract boolean login();
	public abstract boolean logout();
}
