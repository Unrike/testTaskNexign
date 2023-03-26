package ru.unrike.allDataRecords.v2.callObjects.tariff;

import ru.unrike.allDataRecords.v2.callObjects.CallType;

public class DefaultTariff implements TariffCalculator {

    public double calculateCallPrice(CallType callType, int totalMinutesBeforeCall, int minutes) {
        TariffCalculator tariff = TariffPlan.getInstance().getTariffs("03");

        if (callType.getType().equals("02")) return 0.0;

        if (totalMinutesBeforeCall >= 100) {
            return minutes * tariff
                    .calculateCallPrice(callType, totalMinutesBeforeCall, minutes);
        }
        if (totalMinutesBeforeCall + minutes >= 100) {
            return (100 - totalMinutesBeforeCall) * 0.5 +
                    (minutes - (100 - totalMinutesBeforeCall)) *
                            tariff.calculateCallPrice(callType, totalMinutesBeforeCall, minutes);
        }
        return minutes * 0.5;
    }

}
