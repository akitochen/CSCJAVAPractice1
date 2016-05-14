/**
 * 
 */
package com.csc.practice.ATM;

import com.csc.practice.Bank.Bank;

/**
 * @author 189993
 *
 */
public class ATMFactory {
	
	public ATMFactory(){
	}
	
	public static BaseATM createATM(ATMType atmType, Bank bank, int initialMoney){
		BaseATM baseATM = null;
		switch (atmType) {
		case SmallATM :
			baseATM =  new SmallATM(atmType, bank, initialMoney);
			break;
		case CityATM :
			baseATM =  new CityATM(atmType, bank, initialMoney);
			break;
		case EasyATM :
			baseATM =  new EasyATM(atmType, bank, initialMoney);
			break;
		case SuperATM :
			baseATM =  new SuperATM(atmType, bank, initialMoney);
			break;
		default:
			break;
		}	
		return baseATM;
	}
}
