package ru.unrike.allDataRecords.v2.callObjects;

import ru.unrike.allDataRecords.v2.callObjects.tariff.Tariff;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CallData {

    private final DateFormat formatOutput = new SimpleDateFormat("HH:mm:ss");
    private PhoneNumber phoneNumber;
    private CallType callType;
    private CallDate callStart;
    private CallDate callEnd;
    private Tariff tariff;
    private CallPrice callPrice;

    public CallData(PhoneNumber phoneNumber, CallType callType, CallDate callStart, CallDate callEnd, Tariff tariff) {
        formatOutput.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.phoneNumber = phoneNumber;
        this.callType = callType;
        this.callStart = callStart;
        this.callEnd = callEnd;
        this.tariff = tariff;
    }

    public PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public Tariff getTariff() {
        return this.tariff;
    }

    public CallType getCallType() {
        return callType;
    }

    public CallDate getCallStart() {
        return callStart;
    }

    public CallDate getCallEnd() {
        return callEnd;
    }

    public CallPrice getCallPrice() { return callPrice; }

    public void setCallPrice(CallPrice callPrice) { this.callPrice = callPrice; }

    public String getCallTime() { return formatOutput.format(callEnd.getDate().getTime() - callStart.getDate().getTime()); }

}
