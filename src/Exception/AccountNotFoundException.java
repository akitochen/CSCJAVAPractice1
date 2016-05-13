/**
 * 
 */
package Exception;

import com.csc.practice.Bank.Account;

/**
 * @author 189993
 *
 */
public class AccountNotFoundException extends ATMException {

	public AccountNotFoundException(Account account) {
		super(account);
	}
	
	@Override
	public String getMessage() {
		return String.format("卡號%s不存在", account.getCardId());
	}

}
