package com.myob.employeemontlypayslip.models;

import java.util.function.Function;
import java.util.function.Predicate;

class IncomeTaxSlab {
    Predicate<Double> isIncomeSlab;
    Function<Double, Double> calculateIncomeTaxForSlab;

    IncomeTaxSlab(Predicate<Double> isIncomeSlab, Function<Double, Double> calculateIncomeTaxForSlab) {
        this.isIncomeSlab = isIncomeSlab;
        this.calculateIncomeTaxForSlab = calculateIncomeTaxForSlab;
    }
}
