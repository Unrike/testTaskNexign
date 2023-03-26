package ru.unrike.allDataRecords.v2.callObjects.tariff;

public class Tariff {

    private String tariffType;

    public Tariff(String tariffType) {
        this.tariffType = tariffType;
    }

    public Tariff() {}

    public void setTariffType(String tariffType) {
        this.tariffType = tariffType;
    }

    public String getTariffType() {
        return tariffType;
    }

}
