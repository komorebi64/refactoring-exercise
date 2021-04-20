package com.checkr.interviews.entity;

import java.util.HashMap;
import java.util.Map;

public class FundingRecord {

    private final String permalink;
    private final String companyName;
    private final String numberEmployees;
    private final String category;
    private final String city;
    private final String state;
    private final String fundedDate;
    private final String raisedAmount;
    private final String raisedCurrency;
    private final String round;

    public FundingRecord(String[] row) {
        permalink = row[0];
        companyName = row[1];
        numberEmployees = row[2];
        category = row[3];
        city = row[4];
        state = row[5];
        fundedDate = row[6];
        raisedAmount = row[7];
        raisedCurrency = row[8];
        round = row[9];
    }

    public FundingRecord(Map<String, String> mapped) {
        permalink = mapped.get("permalink");
        companyName = mapped.get("company_name");
        numberEmployees = mapped.get("number_employees");
        category = mapped.get("category");
        city = mapped.get("city");
        state = mapped.get("state");
        fundedDate = mapped.get("funded_date");
        raisedAmount = mapped.get("raised_amount");
        raisedCurrency = mapped.get("raised_currency");
        round = mapped.get("round");
    }

    public boolean filter(FundingRecord condition){
        return ((condition.companyName == null || this.companyName.equals(condition.companyName))
                && (condition.state == null || this.state.equals(condition.state))
                && (condition.round == null || this.round.equals(condition.round))
                && (condition.city == null || this.city.equals(condition.city)));
    }

    public Map<String, String> toMap(){
        Map<String, String> mapped = new HashMap<>(16);
        mapped.put("permalink", permalink);
        mapped.put("company_name", companyName);
        mapped.put("number_employees", numberEmployees);
        mapped.put("category", category);
        mapped.put("city", city);
        mapped.put("state", state);
        mapped.put("funded_date", fundedDate);
        mapped.put("raised_amount", raisedAmount);
        mapped.put("raised_currency", raisedCurrency);
        mapped.put("round", round);
        return mapped;
    }
}
