package com.demo.hrworker.model.service;

import com.demo.hrworker.model.entity.Worker;
import com.demo.hrworker.model.exceptions.ResourceNotFoundException;
import com.demo.hrworker.model.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WorkerService {

    @Autowired private WorkerRepository repository;

    public Worker workerById(String id){
        verifyWorkerExists(id);
        Optional<Worker> worker = repository.findById(Long.valueOf(id));
        return worker.get();
    }

    public List<Worker> listAll(){
        return repository.findAll();
    }

    private void verifyWorkerExists(String id) {
        if (repository.findById(Long.valueOf(id)) == null)
            throw new ResourceNotFoundException("Worker not found for id: " + id);
    }
}
