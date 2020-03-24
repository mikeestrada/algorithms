package com.algorithms.service;

import com.algorithms.model.BmrForm;
import com.algorithms.util.Constants;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DailyCaloricIntakeCalculator {
    public BigDecimal calculateDailyCaloricIntake(BmrForm bmrForm) {
        return null;
    }

    public BigDecimal calculateBMR(BmrForm bmrForm) {
        if(Constants.MALE.equals(bmrForm.getSex())) {
            // this.calculateMaleBmr();
        } else {
            // this.calculateFemaleBmr();
        }
        return null;
    }
}
