package com.demo.hrpayroll.model.service;

import com.demo.hrpayroll.model.client.worker.WorkerFeignClient;
import com.demo.hrpayroll.model.entity.Payment;
import com.demo.hrpayroll.model.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServices {

    @Autowired private WorkerFeignClient workerFeignClient;

    public Payment returnPayment(String workId, int days){

        Worker worker = workerFeignClient.findById(workId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
