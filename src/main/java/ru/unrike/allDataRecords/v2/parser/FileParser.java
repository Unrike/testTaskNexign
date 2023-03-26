package ru.unrike.allDataRecords.v2.parser;

import ru.unrike.allDataRecords.v2.callObjects.CallData;

import java.util.List;

public interface FileParser {

    List<CallData> parse(String text);

}
