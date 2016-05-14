/**
 * 
 */
package com.csc.practice;

import com.csc.practice.ATM.ATMType;
import com.csc.practice.ATM.BaseATM;
import com.csc.practice.ATM.CityATM;
import com.csc.practice.Bank.Account;
import com.csc.practice.Bank.Bank;

import Exception.AccountNotFoundException;
import Exception.InsufficientBalanceException;
import Exception.InsufficientMoneyException;
import Exception.NotLoginException;
import Exception.OutOfPassbookUpdateTimesException;
import Exception.OvercapacityException;
import Exception.PasswordException;

/**
 * @author 189993
 *
 */
public class ATMTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/***** 1.建立一間銀行。 *****/
		Bank bank = new Bank();

		/***** 2.為這間銀行建立三個帳戶，分別指定一開始的存款為10,000,000、20,000,000、30,000,000。 *****/
		Account testAccount = bank.addAccount("00012345", "testAccount", "12345", 10000000);
		Account testAccount2 = bank.addAccount("00016789", "testAccount2", "16789", 20000000);
		Account testAccount3 = bank.addAccount("00019876", "testAccount3", "19876", 30000000);

		/*****
		 3.為這間銀行設立兩台ATM：A1, A2，分別是SmallATM與CityATM，
		        分別先放入10,000,000以及20,000,000。
		 ******/
		BaseATM A1 = bank.addATM(ATMType.SmallATM, 10000000);
		BaseATM A2 = bank.addATM(ATMType.CityATM, 20000000);

		/***** 4.計算所有ATM現金總合並印出，預期是30,000,000。 *****/
		System.out.println(String.format("sum Of all ATM : %d", bank.sumOfAtm()));

		try {
			// test for ATM都必須插入提款卡才能使用
			// A1.withDraw(1000);

			// test for 密碼錯誤
			// A1.login(testAccount.getCardId(), "XXX");

			// test for 卡號不存在
			// A1.login("XXX", "XXX");

			/***** 5.以第一個帳號的卡號與密碼登入第一台ATM A1 *****/
			boolean isLogin = A1.login(testAccount.getCardId(), testAccount.getPassword());

			/***** 6.提出現金1,000,000。 *****/
			if (isLogin) {
				// test for 每台ATM一次能領出的錢數量有限制
				// A1.withDraw(5000000);

				/*****
				   例外流程1：超過無摺提款次數
				   連續21次提出現金500,000，在第21次時必須捕捉到OutOfPassbookUpdateTimes，印出錯誤訊息
				 ******/
				/*
				  for (int i = 0; i < 21; i++) {
				  System.out.println(String.format("第%d次提領%d", i + 1, 500000));
				  A1.withDraw(500000); }
				 */

				// test for ATM餘額不足
				/*
				  for (int i = 0; i < 10; i++) {
				  System.out.println(String.format("第%d次提領%d", i + 1,
				  2400000)); A1.withDraw(2400000); }
				 */

				A1.withDraw(1000000);

				// 補款 test
				// A1.putMoney(5000000);

				/***** 7.計算所有ATM現金總合並印出，預期是29,000,000。 *****/
				System.out.println(String.format("sum Of all ATM : %d", bank.sumOfAtm()));

				/***** 8.計算該帳戶剩餘現金，預期9,000,000。 *****/
				System.out.println(String.format("Deposit for %s : %d", testAccount.getName(), A1.query()));
				A1.logout();
			}

			/***** 9.以該帳戶登入第二台ATM A2 *****/
			isLogin = A2.login(testAccount.getCardId(), testAccount.getPassword());

			if (isLogin) {
				/***** 10.從ATM A2存入2,000,000。 *****/
				((CityATM) A2).deposit(2000000);

				/***** 11.計算所有ATM現金總合並印出，預期是31,000,000。 *****/
				System.out.println(String.format("sum Of all ATM : %d", bank.sumOfAtm()));

				/***** 12.計算該帳戶剩餘現金，預期11,000,000。 *****/
				System.out.println(String.format("Deposit for %s : %d", testAccount.getName(), A2.query()));

				// test for Account餘額不足
				/*
				  for (int i = 0; i < 10; i++) {
				  System.out.println(String.format("第%d次提領%d", i + 1,	2400000)); 
				  A2.withDraw(2400000); }
				 */

				// test for 存款會造成ATM現金超過它的最大儲存數量
				// A2.deposit(30000000);

				// test for 補款會造成ATM現金超過它的最大儲存數量
				// A2.putMoney(30000000);

				A2.logout();
			}
		} catch (InsufficientBalanceException exception) {
			System.out.println("InsufficientBalanceException : " + exception.getMessage());
		} catch (InsufficientMoneyException exception) {
			System.out.println("InsufficientMoneyException : " + exception.getMessage());
		} catch (OutOfPassbookUpdateTimesException exception) {
			System.out.println("OutOfPassbookUpdateTimes : " + exception.getMessage());
		} catch (OvercapacityException exception) {
			System.out.println("OutOfPassbookUpdateTimes : " + exception.getMessage());
		} catch (PasswordException exception) {
			System.out.println("PasswordException : " + exception.getMessage());
		} catch (AccountNotFoundException exception) {
			System.out.println("AccountNotFoundException : " + exception.getMessage());
		} catch (NotLoginException exception) {
			System.out.println("NotLoginException : " + exception.getMessage());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}
