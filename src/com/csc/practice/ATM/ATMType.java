/**
 * 
 */
package com.csc.practice.ATM;

/**
 * @author 189993
 *
 */
public enum ATMType {
	SmallATM(1), CityATM(2), SuperATM(3), EasyATM(4);

	private final int atmValue;

	private ATMType(int type) {
		this.atmValue = type;
	}

	public int getATMValue() {
		return this.atmValue;
	}
	
	public static ATMType parseATMType(int type) {
		ATMType atmType = null;
		switch (type) {
		case 1:
			atmType = ATMType.SmallATM;
			break;
		case 2:
			atmType = ATMType.CityATM;
			break;
		case 3:
			atmType = ATMType.SuperATM;
			break;
		case 4:
			atmType = ATMType.EasyATM;
			break;
		default:
			break;
		}
		
		return atmType;
	}

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
