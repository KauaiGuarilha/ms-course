package com.demo.hrpayroll.model.client.worker;

import com.demo.hrpayroll.model.entity.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/rest/workers")
public interface WorkerFeignClient {

    @GetMapping("/{id}")
    ResponseEntity<Worker> findById(@PathVariable String id);
}
