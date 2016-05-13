/**
 * 
 */
package Exception;

import com.csc.practice.Bank.Account;

/**
 * @author 189993
 *
 */
public class InsufficientMoneyException extends ATMException{
	private InsufficientMoneyType insufficientMoneyType;
	private int withdrawMoney = 0;
	private int remainMoney = 0;
	
	public InsufficientMoneyException(InsufficientMoneyType insufficientMoneyType, Account account, int withdrawMoney, int remainMoney) {
		super(account);
		this.insufficientMoneyType = insufficientMoneyType;
		this.withdrawMoney = withdrawMoney;
		this.remainMoney = remainMoney;
	}
	
	@Override
	public String getMessage() {
		if(insufficientMoneyType == InsufficientMoneyType.ATM){
			return String.format("卡號%s , ATM的餘額不足 ! 提款金額 : %d, ATM餘額 : %d", account.getCardId(), withdrawMoney, remainMoney);
		}
		else{
			return String.format("卡號%s , 帳戶的餘額不足 ! 提款金額 : %d, 帳戶餘額 : %d", account.getCardId(), withdrawMoney, remainMoney);
		}
	}

}
