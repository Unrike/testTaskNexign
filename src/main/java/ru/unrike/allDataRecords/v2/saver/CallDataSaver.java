package ru.unrike.allDataRecords.v2.saver;

import ru.unrike.allDataRecords.v2.Subscriber;
import ru.unrike.allDataRecords.v2.callObjects.CallData;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

public class CallDataSaver {

    public boolean save(List<Subscriber> subscribers, String outputPath) {

        for (Subscriber subscriber : subscribers) {
            subscriber.getTariff().getTariffType();
            StringBuilder title = new StringBuilder("Tariff index: " + subscriber.getTariff().getTariffType() + "\n");
            title.append("----------------------------------------------------------------------------\n");
            title.append("Report for phone number " + subscriber.getPhoneNumber().getPhoneNumber() + ":\n");
            title.append("----------------------------------------------------------------------------\n");
            title.append("| Call Type |   Start Time        |     End Time        | Duration | Cost  |\n");
            title.append("----------------------------------------------------------------------------\n");
            title.append(getCallText(subscriber.getCallDataList()));
            title.append("----------------------------------------------------------------------------\n");
            title.append("|                                           Total Cost: |     " + subscriber.getTotalPrice() + " rubles |\n");
            title.append("----------------------------------------------------------------------------\n");

            try (PrintStream out = new PrintStream(new FileOutputStream(outputPath + "reportFor" + subscriber.getPhoneNumber().getPhoneNumber() + ".txt"))) {
                out.print(title);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private String getCallText(List<CallData> callDataList) {
        StringBuilder result = new StringBuilder();
        for (CallData callData : callDataList) {
            result.append("|     ").append(callData.getCallType()).append("    | ").append(callData.getCallStart().toString()).append(" | ").append(callData.getCallEnd().toString()).append(" | ").append(callData.getCallTime()).append(" |  ").append(callData.getCallPrice().getPrice()).append(" |\n");
        }
        return result.toString();
    }

}
