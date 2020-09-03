package com.example.NWM.service.impl;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NWM.dao.jpa.CardJpaDao;
import com.example.NWM.dao.jpa.PaymentJpaDao;
import com.example.NWM.entity.Card;
import com.example.NWM.entity.Payment;
import com.example.NWM.service.PaymentService;
import com.example.NWM.view.CardResponse;
import com.example.NWM.view.PaymentRequest;
import com.example.NWM.view.PaymentResponse;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	CardJpaDao cardDao;

	@Autowired
	PaymentJpaDao paymentDao;

	public static void validate(PaymentRequest request) {

		if (request == null)
			throw new ValidationException("payment request can't be null");

		if (request.getCard() == null)
			throw new ValidationException("enter card details for payment");

		if (request.getCard().getNumber() == null || request.getCard().getCvv() == 0
				|| request.getCard().getExpirationMonth() == null || request.getCard().getExpirationYear() == null) {
			throw new ValidationException("enter all card details for payment");
		}

		int year = Calendar.getInstance().get(Calendar.YEAR);
		if (Integer.parseInt(request.getCard().getExpirationYear()) < year) {
			throw new ValidationException("card year is not valid");
		}
		if (Integer.parseInt(request.getCard().getExpirationMonth()) > 12) {
			throw new ValidationException("card month is not valid");
		}

	}

	@Override
	@Transactional
	public PaymentResponse save(PaymentRequest request) {

		validate(request);

		Payment payment = request.toEntity(request);

		CardResponse response = cardDao.findByNumber(request.getCard().getNumber());

		if (response != null) {
			payment.settCardId(response.getId());
		} else {
			Card card = new Card(request.getCard());
			card = cardDao.save(card);
			payment.settCardId(card.getId());
		}

		payment.setStatus("success");
		payment.setTime(Time.valueOf(LocalTime.now()));
		payment = paymentDao.save(payment);

		PaymentResponse paymentResponse = new PaymentResponse(payment);
		response = cardDao.findByIdAndActiveTrue(payment.getCard().getId());
		paymentResponse.setCardResponse(response);
		paymentResponse.getCardResponse().setId(null);

		return paymentResponse;
	}

}
