/**
 * 
 */
package Exception;

import com.csc.practice.Bank.Account;

/**
 * @author 189993
 *
 */
public class OutOfPassbookUpdateTimesException extends ATMException {
	private int maxPassbookTimes;
	
	public OutOfPassbookUpdateTimesException(Account account, int maxPassbookTimes) {
		super(account);
		this.maxPassbookTimes = maxPassbookTimes;
	}

	@Override
	public String getMessage() {
		return String.format("卡號 %s, 無摺提款次數超過上限%d次", account.getCardId(), maxPassbookTimes);
	}
}
