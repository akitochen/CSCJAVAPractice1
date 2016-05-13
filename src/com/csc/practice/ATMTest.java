/**
 * 
 */
package com.csc.practice;

import com.csc.practice.ATM.ATMType;
import com.csc.practice.ATM.CityATM;
import com.csc.practice.ATM.SmallATM;
import com.csc.practice.Bank.Account;
import com.csc.practice.Bank.Bank;

/**
 * @author 189993
 *
 */
public class ATMTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 1.建立一間銀行。
		Bank bank = new Bank();

		// 2.為這間銀行建立三個帳戶，分別指定一開始的存款為10,000,000、20,000,000、30,000,000。
		Account testAccount = bank.addAccount("00012345", "testAccount", "12345", 10000000);
		Account testAccount2 = bank.addAccount("00016789", "testAccount2", "16789", 20000000);
		Account testAccount3 = bank.addAccount("00019876", "testAccount3", "19876", 30000000);

		// 3.為這間銀行設立兩台ATM：A1,
		// A2，分別是SmallATM與CityATM，分別先放入10,000,000以及20,000,000。
		SmallATM A1 = (SmallATM) bank.addATM(ATMType.SmallATM, 10000000);
		CityATM A2 = (CityATM) bank.addATM(ATMType.CityATM, 20000000);

		// 4.計算所有ATM現金總合並印出，預期是30,000,000。
		System.out.println(String.format("sum Of all ATM : %d", bank.sumOfAtm()));

		try {
			// 5.以第一個帳號的卡號與密碼登入第一台ATM A1
			boolean isLogin = A1.login(testAccount.getCardId(), testAccount.getPassword());

			// 6.提出現金1,000,000。
			if (isLogin) {
				A1.withDraw(1000000);

				// 7.計算所有ATM現金總合並印出，預期是29,000,000。
				System.out.println(String.format("sum Of all ATM : %d", bank.sumOfAtm()));

				// 8.計算該帳戶剩餘現金，預期9,000,000。
				System.out.println(String.format("Deposit for %s : %d", testAccount.getName(), A1.query()));
			}
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		} finally {
			A1.logout();
		}

		try {
			// 9.以該帳戶登入第二台ATM A2
			boolean isLogin = A2.login(testAccount.getCardId(), testAccount.getPassword());

			if (isLogin) {
				// 10.從ATM A2存入2,000,000。
				A2.deposit(2000000);
				
				// 11.計算所有ATM現金總合並印出，預期是31,000,000。
				System.out.println(String.format("sum Of all ATM : %d", bank.sumOfAtm()));
				
				// 12.計算該帳戶剩餘現金，預期11,000,000。
				System.out.println(String.format("Deposit for %s : %d", testAccount.getName(), A2.query()));
			}
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		} finally {
			A2.logout();
		}
	}
}
