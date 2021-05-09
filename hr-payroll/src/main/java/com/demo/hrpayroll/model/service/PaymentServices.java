package com.demo.hrpayroll.model.service;

import com.demo.hrpayroll.model.entity.Payment;
import com.demo.hrpayroll.model.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentServices {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired private RestTemplate restTemplate;

    public Payment returnPayment(String workId, int days){
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", workId);

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
