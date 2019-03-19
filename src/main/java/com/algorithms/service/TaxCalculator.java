package com.algorithms.service;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;

@Service
public class TaxCalculator {

    public String calculateTax(String yearlySalary) {
        double payInt = Double.parseDouble(yearlySalary);
        double taxOwed = 0;

        HashMap<Double, Range> taxBrackets = initTaxBrackets();

        Object[] bracketKeys = taxBrackets.keySet().toArray();
        for (int i = 0; i < taxBrackets.size(); i++) {
            if (payInt > taxBrackets.get(bracketKeys[i]).max) {
                taxOwed += taxBrackets.get(bracketKeys[i]).max * (Double) bracketKeys[i];
            }
            if (payInt > taxBrackets.get(bracketKeys[i]).min &&
                    payInt < taxBrackets.get(bracketKeys[i]).max) {
                taxOwed += (payInt - taxBrackets.get(bracketKeys[i]).min) * (Double) bracketKeys[i];
            }

        }
        NumberFormat taxFmt = new DecimalFormat("#00.00");
        return taxFmt.format(taxOwed);
    }

    private static HashMap<Double, Range> initTaxBrackets() {
        HashMap<Double, Range> taxBrackets = new HashMap<>();
        taxBrackets.put(0.10, new Range(0, 9700));
        taxBrackets.put(0.12, new Range(9701, 39475));
        taxBrackets.put(0.22, new Range(39476, 84200));
        taxBrackets.put(0.24, new Range(84201, 160725));
        taxBrackets.put(0.32, new Range(160726, 204100));
        taxBrackets.put(0.35, new Range(204101, 510300));
        taxBrackets.put(0.37, new Range(510301, Integer.MAX_VALUE));
        return taxBrackets;
    }

    public static class Range {
        int min;
        int max;

        Range(int mn, int mx) {
            min = mn;
            max = mx;
        }
    }
}