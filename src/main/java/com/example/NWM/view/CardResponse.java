package com.example.NWM.view;

public class CardResponse {

	private Long id;
	private String number;

	public CardResponse(Long id, String number) {
		super();
		this.id = id;
		this.number = number;

	}

	public static CardResponse get(CardResponse response) {
		if (response != null) {
			CardResponse cardResponse = new CardResponse(response.getId(), response.getNumber());
			return cardResponse;
		}
		return null;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
