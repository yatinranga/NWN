package com.example.NWM.enums;

public enum CardEnum {

	DebitCard, CreditCard;

	public static boolean matches(String status) {
		for (CardEnum licenseStatus : CardEnum.values()) {
			if (licenseStatus.name().equals(status)) {
				return true;
			}
		}
		return false;
	}
}
