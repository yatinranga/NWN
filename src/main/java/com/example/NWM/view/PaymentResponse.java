package com.example.NWM.view;

import java.sql.Time;

import com.example.NWM.entity.Payment;

public class PaymentResponse {

	private int amount;
	private String currency;
	private String cardType;
	private CardResponse cardResponse;
	private String status;
	private Time time;

	public PaymentResponse(Payment payment) {
		super();
		this.amount = payment.getAmount();
		this.currency = payment.getCurrency();
		this.cardType = payment.getCardType().toString();
		this.status = payment.getStatus();
		this.time = payment.getTime();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public CardResponse getCardResponse() {
		return cardResponse;
	}

	public void setCardResponse(CardResponse cardResponse) {
		this.cardResponse = cardResponse;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
