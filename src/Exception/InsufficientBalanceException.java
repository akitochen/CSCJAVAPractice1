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
		return String.format("���ڪ��B %d �W�L�榸���ڪ��B�W�� !", this.withdrawMoney);
	}
}
