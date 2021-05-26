package com.demo.hrpayroll.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Worker {

    private Long id;
    private String name;
    private Double dailyIncome;
}
