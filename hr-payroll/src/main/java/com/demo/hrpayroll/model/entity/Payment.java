package com.demo.hrpayroll.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private String name;
    private Double dailyIncome;
    private Integer days;

    public double getTotal(){
        return days * dailyIncome;
    }
}
