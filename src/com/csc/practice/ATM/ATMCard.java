/**
 * 
 */
package com.csc.practice.ATM;

/**
 * @author 189993
 *
 */
public class ATMCard {
	private String account = null;
	private String password = null;
	
	public String getAccount() {
		return account;
	}
	
	public String getPassword() {
		return password;
	}
	
	public ATMCard(String account, String password){
		this.account = account;
		this.password = password;
	}
}
