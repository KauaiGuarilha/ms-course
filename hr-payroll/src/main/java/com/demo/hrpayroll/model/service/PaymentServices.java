package com.demo.hrpayroll.model.service;

import com.demo.hrpayroll.model.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentServices {

    public Payment returnPayment(Long workId, int days){
        return new Payment("Bob", 200.0, days);
    }
}
