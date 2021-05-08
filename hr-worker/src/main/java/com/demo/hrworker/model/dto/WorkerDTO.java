package com.demo.hrworker.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDTO {

    private String id;
    private String name;
    private String dailyIncome;
}
