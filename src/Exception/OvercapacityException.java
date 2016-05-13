/**
 * 
 */
package Exception;

import com.csc.practice.Bank.Account;

/**
 * @author 189993
 *
 */
public class OvercapacityException extends ATMException {

	public OvercapacityException(Account account) {
		super(account);
	}
	
	@Override
	public String getMessage() {
		return String.format("卡號 %s, ATM現金超過最大儲存數量", account.getCardId());
	}

}
