package com.demo.hroauth.model.client.users;

import com.demo.hroauth.model.entity.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "hr-user", path = "/rest/users")
public interface UsersFeignClient {

    @GetMapping("/search")
    ResponseEntity<Users> findByEmail(@RequestParam String email);
}
