package com.example.NWM.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.NWM.enums.CardEnum;

@Entity
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@NotNull(message = "number can't be null")
	private String number;
	@NotNull(message = "expirationMonth can't be null")
	private String expirationMonth;
	@NotNull(message = "expirationYear can't be null")
	private String expirationYear;
	@NotEmpty(message = "cvv can't be null")
	private int cvv;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "card can't be null")
	private CardEnum card;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "card")
	private Set<Payment> payment_id;

	public Card() {

	}

	public Card(String number, String expirationMonth, String expirationYear, int cvv, CardEnum card) {

		this.number = number;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
		this.cvv = cvv;
		this.card = card;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public Set<Payment> getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Set<Payment> payment_id) {
		this.payment_id = payment_id;
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

	public CardEnum getCard() {
		return card;
	}

	public void setCard(CardEnum card) {
		this.card = card;
	}

}
