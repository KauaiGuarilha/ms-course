package com.demo.hrpayroll.controller;

import com.demo.hrpayroll.model.entity.Payment;
import com.demo.hrpayroll.model.service.PaymentServices;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payments")
public class PaymentController {

    @Autowired private PaymentServices services;

    @HystrixCommand(fallbackMethod = "returnPaymentAlternative")
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> returnPayment(@PathVariable String workerId, @PathVariable Integer days){
        return new ResponseEntity<>(services.returnPayment(workerId, days), HttpStatus.OK);
    }

    public ResponseEntity<Payment> returnPaymentAlternative(String workerId, Integer days){
        Payment payment = new Payment("Kauai", 600.0, days);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
}
