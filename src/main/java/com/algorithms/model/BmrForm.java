package com.algorithms.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BmrForm {
    private BigDecimal weight;
    private BigDecimal heightFeet;
    private BigDecimal heightInches;
    private int age;
    private String sex;
}
