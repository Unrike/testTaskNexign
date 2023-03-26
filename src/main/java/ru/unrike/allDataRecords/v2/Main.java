package ru.unrike.allDataRecords.v2;

public class Main {

    public static void main(String[] args) {

        String inputPath = "src\\main\\resources\\input.txt";
        String outputPath = "reports\\";

        CDR cdr = new CDR();
        cdr.process(inputPath, outputPath);

    }

}
