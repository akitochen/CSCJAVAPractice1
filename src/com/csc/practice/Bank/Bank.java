/**
 * 
 */
package com.csc.practice.Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csc.practice.ATM.ATMFactory;
import com.csc.practice.ATM.ATMType;
import com.csc.practice.ATM.BaseATM;

import sun.rmi.runtime.Log;

/**
 * @author 189993
 *
 */
public class Bank implements IBank {
	private ATMFactory atmFactory = null;
	private List<BaseATM> atmList = null;
	private Map<String, Account> accountMap = null;
	// private int currentMoney = 0;

	public List<BaseATM> getAtmList() {
		return atmList;
	}

	public Map<String, Account> getAccountList() {
		return accountMap;
	}

	// public int getCurrentMoney() {
	// return currentMoney;
	// }

	public Bank() {
		atmFactory = new ATMFactory(this);
		atmList = new ArrayList<>();
		accountMap = new HashMap<String, Account>();
	}

	@Override
	public boolean isAccountExists(String cardId) {
		if (cardId != null && accountMap.containsKey(cardId)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int sumOfAtm() {
		int sum = 0;
		for (BaseATM baseATM : atmList) {
			sum += baseATM.queryAll();
		}
		return sum;
	}

	@Override
	public BaseATM addATM(ATMType atmType, int initialMoney) {
		BaseATM baseATM = atmFactory.createATM(atmType, initialMoney);
		atmList.add(baseATM);
		System.out.println("Add ATM : " + baseATM.toString());
		return baseATM;
	}

	@Override
	public Account addAccount(String cardId, String name, String password, int deposit) {
		Account account = new Account(cardId, name, password, deposit);
		accountMap.put(account.getCardId(), account);
		System.out.println("Add Account : " + account.toString());
		return account;
	}

	@Override
	public Account getAccount(String cardId) {
		if (cardId != null && !cardId.isEmpty()) {
			return accountMap.get(cardId);
		} else {
			return null;
		}
	}

}
