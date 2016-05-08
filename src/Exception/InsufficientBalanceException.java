/**
 * 
 */
package Exception;

/**
 * @author 189993
 *
 */
public class InsufficientBalanceException extends Exception {
	private int withdrawMoney = 0;
	
	public InsufficientBalanceException(int withdrawMoney){
		this.withdrawMoney = withdrawMoney;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return String.format("提款金額 %d 超過單次提款金額上限 !", this.withdrawMoney);
	}
}
