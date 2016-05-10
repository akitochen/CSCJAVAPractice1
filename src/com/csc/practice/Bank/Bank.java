/**
 * 
 */
package com.csc.practice.Bank;

import java.util.ArrayList;
import java.util.List;

import com.csc.practice.ATM.BaseATM;

/**
 * @author 189993
 *
 */
public class Bank extends AbstractBank{
	private List<BaseATM> atmList = new ArrayList<>();

	@Override
	boolean isAccountExists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	int sumOfAtm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	boolean addATM() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean addAccount() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
