/**
 * 
 */
package Exception;

/**
 * @author 189993
 *
 */
public class AccountNotFoundException extends ATMException {
	private String cardId;
	
	public AccountNotFoundException(String cardId) {
		this.cardId = cardId;
	}
	
	@Override
	public String getMessage() {
		return String.format("卡號%s不存在", cardId);
	}

}
