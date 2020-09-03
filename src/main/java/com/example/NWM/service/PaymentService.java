package com.example.NWM.service;

import com.example.NWM.view.PaymentRequest;
import com.example.NWM.view.PaymentResponse;

public interface PaymentService {

	PaymentResponse save(PaymentRequest request);

}
