/**
 * 
 */
package com.csc.practice.ATM.Interface;

import Exception.NotLoginException;

/**
 * @author 189993
 *
 */
public interface Depositable {
	void deposit(int money)throws NotLoginException;
}
