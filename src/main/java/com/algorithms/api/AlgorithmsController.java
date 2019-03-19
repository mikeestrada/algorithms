package com.algorithms.api;

import com.algorithms.service.TaxCalculator;
import com.algorithms.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlgorithmsController {

    @Autowired
    private TaxCalculator taxCalculationService;

    @GetMapping("/calculate-tax")
    public String calculateTax(@RequestParam(value="salary") String yearlySalary) {
        if (yearlySalary.matches(Constants.ALPHA_REGEX)) {
            return "Please submit a valid numeric yearly salary.";
        }
        return this.taxCalculationService.calculateTax(yearlySalary);
    }
}

