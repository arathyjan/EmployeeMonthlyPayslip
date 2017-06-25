package java.com.myob.employeemontlypayslip;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class IncomeTaxSlab {
    Map<Predicate, Function> slabs;

    public IncomeTaxSlab create() {
        return new IncomeTaxSlab();
    }
}
