package ru.unrike.allDataRecords.v2;

import ru.unrike.allDataRecords.v2.callObjects.*;
import ru.unrike.allDataRecords.v2.callObjects.tariff.Tariff;
import ru.unrike.allDataRecords.v2.callObjects.tariff.TariffPlan;

import java.util.ArrayList;
import java.util.List;

public class Subscriber {

    private PhoneNumber phoneNumber;
    private Tariff tariff;
    private Integer totalMinutes;
    private double totalPrice;
    private List<CallData> callDataList;

    public Subscriber(PhoneNumber phoneNumber, Tariff tariff) {
        this.totalMinutes = 0;
        this.phoneNumber = phoneNumber;
        this.tariff = tariff;
        callDataList = new ArrayList<>();
    }

    public Subscriber(PhoneNumber phoneNumber, Tariff tariff, int totalMinutes, List<CallData> callDataList) {
        this.phoneNumber = phoneNumber;
        this.tariff = tariff;
        this.totalMinutes = totalMinutes;
        this.callDataList = callDataList;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public Integer getTotalMinutes() {
        return totalMinutes;
    }

    public List<CallData> getCallDataList() {
        return callDataList;
    }

    public void addCall(CallData callData) {
         int currentMinutes = getMinutes(callData.getCallStart(), callData.getCallEnd());

        double price = TariffPlan
                .getInstance()
                .getTariffs(callData.getTariff().getTariffType())
                .calculateCallPrice(callData.getCallType(), totalMinutes, currentMinutes);

        callData.setCallPrice(new CallPrice(price));
        totalMinutes += currentMinutes;
        totalPrice += price;
        callDataList.add(callData);
    }

    private int getMinutes(CallDate callStart, CallDate callEnd) {
        return (int) Math.ceil((callEnd.getDate().getTime() - callStart.getDate().getTime()) / 1000.0 / 60);
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
