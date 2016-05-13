/**
 * 
 */
package com.csc.practice.ATM.Interface;

import Exception.InsufficientBalanceException;
import Exception.InsufficientMoneyException;
import Exception.NotLoginException;
import Exception.OutOfPassbookUpdateTimesException;

/**
 * @author 189993
 *
 */
public interface WithDrawable {
	int withDraw(int money) throws NotLoginException, OutOfPassbookUpdateTimesException, 
		InsufficientBalanceException, InsufficientMoneyException;
}
