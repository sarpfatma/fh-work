package com.maya.homework.models.responses;


import com.maya.homework.models.CurrencyModel;

public class TransactionReportResponse {
    CurrencyModel[] currencies;
    int total;

    public CurrencyModel[] getCurrencies() {
        return currencies;
    }

    public void setCurrencies(CurrencyModel[] currencies) {
        this.currencies = currencies;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
