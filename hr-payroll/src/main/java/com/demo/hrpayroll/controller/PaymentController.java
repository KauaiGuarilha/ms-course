package com.demo.hrpayroll.controller;

import com.demo.hrpayroll.model.entity.Payment;
import com.demo.hrpayroll.model.service.PaymentServices;
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

    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> returnPayment(@PathVariable Long workerId, @PathVariable Integer days){
        return new ResponseEntity<>(services.returnPayment(workerId, days), HttpStatus.OK);
    }
}
