package com.example.NWM.view;

public class PaymentRequest {

	private int amount;
	private String currency;
	private String type;

	private CardRequest card;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CardRequest getCard() {
		return card;
	}

	public void setCard(CardRequest card) {
		this.card = card;
	}

}
