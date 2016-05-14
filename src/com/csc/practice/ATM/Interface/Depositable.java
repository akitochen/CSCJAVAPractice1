/**
 * 
 */
package com.csc.practice.ATM.Interface;

import Exception.NotLoginException;
import Exception.OvercapacityException;

/**
 * @author 189993
 *
 */
public interface Depositable {
	void deposit(int money)throws NotLoginException, OvercapacityException;
}
