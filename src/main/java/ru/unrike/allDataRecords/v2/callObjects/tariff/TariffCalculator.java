package ru.unrike.allDataRecords.v2.callObjects.tariff;

import ru.unrike.allDataRecords.v2.callObjects.CallType;

public interface TariffCalculator {

    double calculateCallPrice(CallType callType, int totalMinutesBeforeCall, int minutes);

}
