package com.demo.hruser.model.service;

import com.demo.hruser.model.entity.Users;
import com.demo.hruser.model.exceptions.ResourceNotFoundException;
import com.demo.hruser.model.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired private UsersRepository repository;

    public Users usersById(String id){
        verifyWorkerExists(id);
        Optional<Users> users = repository.findById(Long.valueOf(id));
        return users.get();
    }

    public Users usersByEmail(String email){
        if (Objects.isNull(email)) return null;

        return repository.findByEmail(email);
    }

    private void verifyWorkerExists(String id) {
        if (repository.findById(Long.valueOf(id)) == null)
            throw new ResourceNotFoundException("Worker not found for id: " + id);
    }
}
