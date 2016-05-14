/**
 * 
 */
package Exception;

import com.csc.practice.Bank.Account;

/**
 * @author 189993
 *
 */
public class ATMException extends Exception {
	protected Account account  = null;
	
	public ATMException(){
	}
	
	public ATMException(Account account){
		this.account = account;
	}
}
