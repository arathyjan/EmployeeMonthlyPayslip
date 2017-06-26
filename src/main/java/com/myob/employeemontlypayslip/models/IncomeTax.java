package com.myob.employeemontlypayslip.models;

import java.util.ArrayList;
import java.util.List;

class IncomeTax {
    private static final List<IncomeTaxSlab> slabs = generateIncomeTaxSlab();

    static Double calculateIncomeTax(Double income) {
        IncomeTaxSlab incomeTaxSlab = findIncomeTaxSlab(income);
        return calculateIncomeTaxForSlab(incomeTaxSlab, income);
    }

    private static Double calculateIncomeTaxForSlab(IncomeTaxSlab incomeTaxSlab, Double income) {
        return incomeTaxSlab.calculateIncomeTaxForSlab.apply(income);
    }

    private static IncomeTaxSlab findIncomeTaxSlab(Double income) {
        return slabs
                .stream()
                .filter((slab) -> slab.isIncomeSlab.test(income))
                .findFirst()
                .get();
    }

    private static List generateIncomeTaxSlab() {
        List<IncomeTaxSlab> slabs = new ArrayList<>();
        slabs.add(new IncomeTaxSlab(income -> income > 0 && income <= 18200, income -> 0.0));
        slabs.add(new IncomeTaxSlab(income -> income > 18200 && income <= 37000, income -> (income - 18200) * .19));
        slabs.add(new IncomeTaxSlab(income -> income > 37001 && income <= 80000, income -> 3572 + (income - 37000) * .325));
        slabs.add(new IncomeTaxSlab(income -> income > 80001 && income <= 180000, income -> 17547 + (income - 80000) * .37));
        slabs.add(new IncomeTaxSlab(income -> income > 180001, income -> 54547 + (income - 180000) * .45));
        return slabs;
    }
}
