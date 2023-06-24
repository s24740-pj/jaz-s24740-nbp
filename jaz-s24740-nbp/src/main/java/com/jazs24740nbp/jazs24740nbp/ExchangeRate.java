package com.jazs24740nbp.jazs24740nbp;

import java.util.List;

public class ExchangeRate {

    private String currency;
    private String code;
    private List<Rates> Rates;

    public ExchangeRate(String currency, String code, List<com.jazs24740nbp.jazs24740nbp.Rates> rates) {
        this.currency = currency;
        this.code = code;
        Rates = rates;
    }

    public ExchangeRate() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<com.jazs24740nbp.jazs24740nbp.Rates> getRates() {
        return Rates;
    }

    public void setRates(List<com.jazs24740nbp.jazs24740nbp.Rates> rates) {
        Rates = rates;
    }
}
