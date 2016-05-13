/**
 * 
 */
package com.csc.practice.ATM.Interface;

import Exception.NotLoginException;

/**
 * @author 189993
 *
 */
public interface Queryable {
	int query()throws NotLoginException;
	int queryAll();
}
