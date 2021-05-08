package com.demo.hrworker.model.repository;

import com.demo.hrworker.model.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, UUID> {}
