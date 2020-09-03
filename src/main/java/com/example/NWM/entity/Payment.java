package com.example.NWM.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.example.NWM.enums.CardEnum;

@Entity
@DynamicInsert
@DynamicUpdate
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@NotNull
	private int amount;
	@NotNull
	private String currency;
	private String status;
	private Time time;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "card can't be null")
	private CardEnum cardType;

	@OneToOne
	@JoinColumn(name = "card_id", referencedColumnName = "id")
	private Card card;

	private Long tCardId;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public CardEnum getCardType() {
		return cardType;
	}

	public void setCardType(CardEnum cardType) {
		this.cardType = cardType;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Long gettCardId() {
		return tCardId;
	}

	public void settCardId(Long tCardId) {
		if (tCardId != null) {
			this.card = new Card();
			this.card.setId(tCardId);
		}
		this.tCardId = tCardId;
	}

}
