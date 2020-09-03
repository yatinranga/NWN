package com.example.NWM.view;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CardRequest {

	@NotEmpty(message = "card number can't be null")
	private String number;
	@NotEmpty(message = "expiration month can't be null")
	private String expirationMonth;
	@NotEmpty(message = "expiration year can't be null")
	private String expirationYear;
	@NotNull(message = "card cvv can't be null")
	@Max(3)
	@Min(3)
	private int cvv;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public String getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(String expirationYear) {
		this.expirationYear = expirationYear;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

}
