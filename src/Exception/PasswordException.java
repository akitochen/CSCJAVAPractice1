/**
 * 
 */
package Exception;

import com.csc.practice.Bank.Account;

/**
 * @author 189993
 *
 */
public class PasswordException extends ATMException {

	public PasswordException(Account account) {
		super(account);
	}

	@Override
	public String getMessage() {
		return String.format("卡號%s, 密碼錯誤!", account.getCardId());
	}
}
