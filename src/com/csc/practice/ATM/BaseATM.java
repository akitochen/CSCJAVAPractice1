/**
 * 
 */
package com.csc.practice.ATM;

import com.csc.practice.ATM.Interface.Queryable;
import com.csc.practice.ATM.Interface.WithDrawable;
import com.csc.practice.Bank.Bank;

/**
 * @author 189993
 *
 */
public class BaseATM extends AbstractATM implements WithDrawable, Queryable{
	protected ATMType myATMType = null; 
	protected Bank ownerBank = null;
		
	public BaseATM(ATMType type, Bank bank) {
		this.myATMType = type;
		this.ownerBank = bank;
	}

	@Override
	public boolean login(){
		
		return false;
	}

	@Override
	public boolean logout(){
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int withDraw(int money) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int query() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean putMoney() {
		// TODO Auto-generated method stub
		return false;
	}

}
