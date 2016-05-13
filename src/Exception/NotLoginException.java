/**
 * 
 */
package Exception;

/**
 * @author 189993
 *
 */
public class NotLoginException extends Exception {
	@Override
	public String getMessage() {
		return "帳號未登入!";
	}
}
