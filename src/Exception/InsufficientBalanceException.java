/**
 * 
 */
package Exception;

import com.csc.practice.Bank.Account;

/**
 * @author 189993
 *
 */
public class InsufficientBalanceException extends ATMException {
	private int withdrawMoney = 0;
	private int limitMoney = 0;
	
	public InsufficientBalanceException(Account account, int withdrawMoney, int limitMoney){
		super(account);
		this.withdrawMoney = withdrawMoney;
		this.limitMoney = limitMoney;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return String.format("卡號 %s, 提款金額%s超過單次領出的金額%s上限 ", account.getCardId(), this.withdrawMoney, this.limitMoney);
	}
}
