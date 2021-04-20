package com.checkr.interviews;

import java.util.*;

import com.checkr.interviews.entity.FundingRecord;
import com.checkr.interviews.exception.NoSuchEntryException;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class FundingRaised {

    public static List<Map<String, String>> where(FundingRecord options) throws IOException {
        List<FundingRecord> csvData = readCsv();

        return csvData.stream()
                .filter(data -> data.filter(options))
                .map(FundingRecord::toMap)
                .collect(Collectors.toList());
    }

    public static List<Map<String, String>> where(Map<String, String> options) throws IOException {
        return where(new FundingRecord(options));
    }

    public static Map<String, String> findBy(Map<String, String> options) throws IOException, NoSuchEntryException {
        List<Map<String, String>> list = where(new FundingRecord(options));
        if (list.isEmpty()) {
            throw new NoSuchEntryException();
        }

        return list.get(0);
    }

    private static List<FundingRecord> readCsv() throws IOException {
        List<FundingRecord> csvData = new ArrayList<>();
        CSVReader reader = new CSVReader(new FileReader("startup_funding.csv"));
        String[] row;

        while ((row = reader.readNext()) != null) {
            csvData.add(new FundingRecord(row));
        }

        reader.close();
        csvData.remove(0);
        return csvData;
    }

}
