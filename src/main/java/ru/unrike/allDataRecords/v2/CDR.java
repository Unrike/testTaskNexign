package ru.unrike.allDataRecords.v2;

import ru.unrike.allDataRecords.v2.callObjects.CallData;
import ru.unrike.allDataRecords.v2.loader.FileLoader;
import ru.unrike.allDataRecords.v2.loader.TxtFileLoader;
import ru.unrike.allDataRecords.v2.parser.FileParser;
import ru.unrike.allDataRecords.v2.parser.TxtFileParser;
import ru.unrike.allDataRecords.v2.saver.CallDataSaver;

import java.util.List;

public class CDR {

    private FileLoader txtFileLoader = new TxtFileLoader();
    private FileParser fileParser = new TxtFileParser();
    private CallDataManager callDataManager = new CallDataManager();
    private CallDataSaver callDataSaver = new CallDataSaver();

    public void process(String inputPath, String outputPath) {
        String txt = txtFileLoader.load(inputPath);
        List<CallData> callData = fileParser.parse(txt);
        List<Subscriber> subscribers = callDataManager.manage(callData);
        callDataSaver.save(subscribers, outputPath);
    }

}
