package ru.unrike.allDataRecords.v2.parser;

import ru.unrike.allDataRecords.v2.callObjects.CallData;
import ru.unrike.allDataRecords.v2.callObjects.CallDate;
import ru.unrike.allDataRecords.v2.callObjects.CallType;
import ru.unrike.allDataRecords.v2.callObjects.PhoneNumber;
import ru.unrike.allDataRecords.v2.callObjects.tariff.Tariff;

import java.util.*;

public class TxtFileParser implements FileParser {

    @Override
    public List<CallData> parse(String text) {
        String[] callDataRows = text.split("\n");
        List<CallData> callDataList = new ArrayList<>();

        for (String callDataRow : callDataRows) {
            List<String> data = Arrays
                    .stream(callDataRow.split(","))
                    .map(String::trim)
                    .toList();

            CallType callType = new CallType(data.get(0));
            PhoneNumber number = new PhoneNumber(data.get(1));
            CallDate callDateStart = new CallDate(data.get(2));
            CallDate callDateEnd = new CallDate(data.get(3));
            Tariff tariff = new Tariff(data.get(4));
            CallData callData = new CallData(number, callType, callDateStart, callDateEnd, tariff);
            callDataList.add(callData);
        }
        return callDataList;
    }

}
