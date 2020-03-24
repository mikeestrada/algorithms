package com.algorithms.api;

import com.algorithms.model.BmrForm;
import com.algorithms.service.DailyCaloricIntakeCalculator;
import com.algorithms.service.StringReverse;
import com.algorithms.service.TaxCalculator;
import com.algorithms.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class AlgorithmsController {

    @Autowired
    private TaxCalculator taxCalculationService;
    @Autowired
    private DailyCaloricIntakeCalculator caloricIntakeService;
    @Autowired
    private StringReverse stringService;

    @GetMapping("/calculate-tax")
    public String calculateTax(@RequestParam(value="salary") String yearlySalary) {
        if (yearlySalary.matches(Constants.ALPHA_REGEX)) {
            return "Please submit a valid numeric yearly salary.";
        }
        return this.taxCalculationService.calculateTax(yearlySalary);
    }

    @PostMapping("/bmr")
    public BigDecimal calculateBMR(@RequestBody BmrForm bmrForm) {
        return this.caloricIntakeService.calculateDailyCaloricIntake(bmrForm);
    }

    @PostMapping("/caloric-intake")
    public BigDecimal calculateDailyCaloricIntake(@RequestBody BmrForm bmrForm) {
        return this.caloricIntakeService.calculateDailyCaloricIntake(bmrForm);
    }

    @GetMapping("/strings")
    public String reverse(@RequestParam(value="wordsOrSent") String wordsOrSent,
                          @RequestParam(value="given") String given) {
        switch (wordsOrSent) {
            case "words":
                return this.stringService.reverseWords(given);
            case "sent":
                return this.stringService.reverseSentence(given);
        }
        return this.stringService.reverseString(given);
    }
}

