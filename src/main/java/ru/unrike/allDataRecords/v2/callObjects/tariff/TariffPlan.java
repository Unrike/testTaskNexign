package ru.unrike.allDataRecords.v2.callObjects.tariff;

import java.util.HashMap;
import java.util.Map;

public class TariffPlan {

    private Map<String, TariffCalculator> tariffs = new HashMap<>();

    private static volatile TariffPlan INSTANCE;

    private TariffPlan() {
        tariffs.put("03", new EachMinuteTariff());
        tariffs.put("06", new UnlimitedTariff());
        tariffs.put("11", new DefaultTariff());
    }

    public static TariffPlan getInstance() {
        if (INSTANCE == null) {
            synchronized (TariffPlan.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TariffPlan();
                }
            }
        }
        return INSTANCE;
    }

    public TariffCalculator getTariffs(String type) {
        return tariffs.get(type);
    }
}
