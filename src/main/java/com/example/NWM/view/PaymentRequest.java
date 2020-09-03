package com.example.NWM.view;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.NWM.entity.Payment;
import com.example.NWM.enums.CardEnum;

public class PaymentRequest {

	@NotNull
	@Min(1)
	private int amount;
	private String currency;
	@NotEmpty
	private String type;

	@NotNull
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

	public Payment toEntity(PaymentRequest request) {

		Payment payment = new Payment();
		payment.setAmount(request.getAmount());
		payment.setCurrency("USD");
		payment.setCardType(CardEnum.valueOf(request.getType()));

		return payment;
	}

}
