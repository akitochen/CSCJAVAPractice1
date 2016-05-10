/**
 * 
 */
package com.csc.practice.Bank;

/**
 * @author 189993
 *
 */
public class Account {
	private final int MAX_PASSBOOK_TIMES = 20;
	private int cardId;
	private String name;
	private String password;
	private int passbookTimes;
	private int deposit;

	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPassbookTimes() {
		return passbookTimes;
	}
	public void setPassbookTimes(int passbookTimes) {
		this.passbookTimes = passbookTimes;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	
}
