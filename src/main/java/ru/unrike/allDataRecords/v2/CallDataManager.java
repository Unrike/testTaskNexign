package ru.unrike.allDataRecords.v2;

import ru.unrike.allDataRecords.v2.callObjects.CallData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CallDataManager {

    public List<Subscriber> manage(List<CallData> callDataList) {
        Map<String, Subscriber> phoneCallData = new HashMap<>();
        for (CallData callData: callDataList) {
            if (!phoneCallData.containsKey(callData.getPhoneNumber().getPhoneNumber())) {
                phoneCallData.put(callData.getPhoneNumber().getPhoneNumber(), new Subscriber(callData.getPhoneNumber(), callData.getTariff()));
            }
            phoneCallData.get(callData.getPhoneNumber().getPhoneNumber()).addCall(callData);
        }
        return phoneCallData.values().stream().toList();
    }

}
