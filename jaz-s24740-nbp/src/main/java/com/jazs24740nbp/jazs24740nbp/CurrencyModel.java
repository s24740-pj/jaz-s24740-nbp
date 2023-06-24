package com.jazs24740nbp.jazs24740nbp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;
import java.sql.Time;

@Schema
@Entity
public class CurrencyModel {

    @Schema(description = "ID of record", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Schema(description = "Type of currency to check", example = "USD")
    private String currency;
    @Schema(description = "Beginning date", example = "2023-04-02")
    private String startDate;
    @Schema(description = "End date", example = "2023-04-22")
    private String endDate;
    @Schema(description = "Calculated avarage currency based on currency and interval of time", example = "4.53")
    private double avarage_currency;
    @Schema(description = "Date that avarage currency was calculated", example = "2023-04-24")
    private Date record_date;
    @Schema(description = "Time that avarage currency was calculated", example = "11:11:42")
    private Time record_time;

    public CurrencyModel(String currency, String startDate, String endDate, double avarage_currency, Date record_date, Time record_time) {
        this.currency = currency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.avarage_currency = avarage_currency;
        this.record_date = record_date;
        this.record_time = record_time;
    }

    public CurrencyModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getAvarage_currency() {
        return avarage_currency;
    }

    public void setAvarage_currency(double avarage_currency) {
        this.avarage_currency = avarage_currency;
    }

    public Date getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Date record_date) {
        this.record_date = record_date;
    }

    public Time getRecord_time() {
        return record_time;
    }

    public void setRecord_time(Time record_time) {
        this.record_time = record_time;
    }
}