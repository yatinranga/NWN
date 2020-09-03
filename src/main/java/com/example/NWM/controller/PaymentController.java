package com.example.NWM.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NWM.service.PaymentService;
import com.example.NWM.view.PaymentRequest;
import com.example.NWM.view.PaymentResponse;

@RestController
@RequestMapping("/")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@PostMapping(value = "project", produces = { "application/json" }, consumes = { "application/json" })
	public PaymentResponse save(@Valid @RequestBody PaymentRequest request) {
		return paymentService.save(request);

	}

}
