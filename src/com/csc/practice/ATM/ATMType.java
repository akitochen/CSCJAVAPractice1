/**
 * 
 */
package com.csc.practice.ATM;

/**
 * @author 189993
 *
 */
public enum ATMType {
	SmallATM, 
	CityATM, 
	SuperATM,
	EasyATM;

	public static ATMType parseATMType(String type) {
		ATMType atmType = null;
		String typeString = type.toUpperCase();
		switch (typeString) {
		case "SMALLATM":
			atmType = ATMType.SmallATM;
			break;
		case "CITYATM":
			atmType = ATMType.CityATM;
			break;
		case "SUPERATM":
			atmType = ATMType.SuperATM;
			break;
		case "EASYATM":
			atmType = ATMType.EasyATM;
			break;
		default:
			break;
		}
		return atmType;
	}
}
