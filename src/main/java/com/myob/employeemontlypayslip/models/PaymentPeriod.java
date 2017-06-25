package com.myob.employeemontlypayslip.models;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PaymentPeriod {
    private Date startDate;
    private Date endDate;

    PaymentPeriod() {
    }

    public PaymentPeriod(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    static PaymentPeriod createInstance(String paymentPeriodString) {
        String[] splitDates = paymentPeriodString.split(" – ");
        Date startDate = parseStringDate(splitDates[0]);
        Date endDate = parseStringDate(splitDates[1]);
        return new PaymentPeriod(startDate, endDate);
    }

    private static Date parseStringDate(String splitDate) {
        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM");
        try {
            date = simpleDateFormat.parse(splitDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        date.setYear(date.getMonth() >= 6 ? 2012 : 2013);
        return date;
    }

    @Override
    public String toString() {
        Format formatter = new SimpleDateFormat("dd MMMM");
        return formatter.format(startDate) + " – " + formatter.format(endDate);
    }
}
