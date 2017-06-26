package com.myob.employeemontlypayslip.models;

import com.myob.employeemontlypayslip.exceptions.BadInputException;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PaymentPeriod {
    private static final String DATE_FORMAT = "dd MMMM";
    private static final String DATE_SEPARATOR = " - ";
    private static final int JUNE = 6;
    private Date startDate;
    private Date endDate;

    public PaymentPeriod(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    Date getStartDate() {
        return startDate;
    }

    Date getEndDate() {
        return endDate;
    }

    static PaymentPeriod createInstance(String paymentPeriodString) {
        String[] splitDates = paymentPeriodString.split(DATE_SEPARATOR);

        if(splitDates.length != 2)
            throw new BadInputException("Bad Input: Date format should be 'dd MMM - dd MMM' ");

        Date startDate = parseStringDate(splitDates[0]);
        Date endDate = parseStringDate(splitDates[1]);

        return new PaymentPeriod(startDate, endDate);
    }

    private static Date parseStringDate(String splitDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

        try {
            Date date = simpleDateFormat.parse(splitDate);
            date.setYear(date.getMonth() >= JUNE ? 2012 : 2013);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            throw new BadInputException("Bad Input: Date format should be 'dd MMM - dd MMM'");
        }
    }

    @Override
    public String toString() {
        Format formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(startDate) + DATE_SEPARATOR + formatter.format(endDate);
    }
}
