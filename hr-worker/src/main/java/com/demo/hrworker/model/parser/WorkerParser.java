package com.demo.hrworker.model.parser;

import com.demo.hrworker.model.dto.WorkerDTO;
import com.demo.hrworker.model.entity.Worker;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class WorkerParser {

    public Worker toWorker(WorkerDTO dto){
        return Worker.builder()
                .id(Objects.isNull(dto.getId()) ? null : UUID.fromString(dto.getId()))
                .name(dto.getName())
                .dailyIncome(dto.getDailyIncome())
                .build();
    }

    public WorkerDTO toResponse(Worker worker){
        return WorkerDTO.builder()
                .id(worker.getId().toString())
                .name(worker.getName())
                .dailyIncome(worker.getDailyIncome())
                .build();
    }
}
