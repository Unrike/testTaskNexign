package ru.unrike.allDataRecords.v2.callObjects;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CallDate {

    private Date date;

    DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
    DateFormat formatOutput = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public CallDate(String date) {
        try {
            this.date = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            this.date = null;
        }
    }

    public Date getDate() {
        return this.date;
    }

    public String toString() {
        return formatOutput.format(date);
    }

}
