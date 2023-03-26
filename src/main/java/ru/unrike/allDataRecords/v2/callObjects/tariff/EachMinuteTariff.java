package ru.unrike.allDataRecords.v2.callObjects.tariff;

import ru.unrike.allDataRecords.v2.callObjects.CallType;

public class EachMinuteTariff implements TariffCalculator {

    public double calculateCallPrice(CallType callType, int totalMinutesBeforeCall, int minutes) {
        return minutes * 1.5;
    }

}
