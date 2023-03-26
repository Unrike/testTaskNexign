package ru.unrike.allDataRecords.v2.callObjects.tariff;

import ru.unrike.allDataRecords.v2.callObjects.CallType;

public class UnlimitedTariff implements TariffCalculator {

    public double calculateCallPrice(CallType callType, int totalMinutesBeforeCall, int minutes) {
        if (totalMinutesBeforeCall == 0 && minutes < 300) {
            return 100.0;
        }
        if (totalMinutesBeforeCall == 0) {
            return 100.0 + (minutes - 300.0) * 1.0;
        }
        if (minutes + totalMinutesBeforeCall < 300) {
            return 0.0;
        }
        if (minutes + totalMinutesBeforeCall >= 300 && totalMinutesBeforeCall < 300) {
            return minutes - (300 - totalMinutesBeforeCall) * 1.0;
        }
        return minutes * 1.0;
    }

}
