package ru.unrike.allDataRecords.v2.callObjects;

public class CallType {

    private String type;

    public CallType(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }

    public String getType() {
        return this.type;
    }
}
