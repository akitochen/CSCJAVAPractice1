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
	private OvercapacityType overcapacityType;
    private int putMoney;
    private int remainMoney;
    private int maxMoney;
	
	public OvercapacityException(OvercapacityType overcapacityType, Account account, int putMoney, int remainMoney, int maxMoney) {
		super(account);
		this.overcapacityType = overcapacityType;
		this.putMoney = putMoney;
		this.remainMoney = remainMoney;
		this.maxMoney = maxMoney;
	}
	
	@Override
	public String getMessage() {
		if(this.overcapacityType == OvercapacityType.Bank){
			return String.format("銀行欲補款%d, ATM目前現金%d, 超過ATM最大現金儲存數量%d", 
					putMoney, remainMoney, maxMoney);
		}
		else{
			return String.format("卡號 %s欲存入%d, ATM目前現金%d, 超過ATM最大現金儲存數量%d", 
					account.getCardId(), putMoney, remainMoney, maxMoney);
		}
	}
}
