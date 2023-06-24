package com.jazs24740nbp.jazs24740nbp;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class CurrencyService {

    private final RestTemplate restTemplate;

    private final CurrencyRepository currencyRepository;

    public CurrencyService(RestTemplate restTemplate, CurrencyRepository currencyRepository) {
        this.restTemplate = restTemplate;
        this.currencyRepository = currencyRepository;
    }

    public double calculateAvarageCurrency(String currency, String start_date, String end_date){

        String apiUrl = "http://api.nbp.pl/api/exchangerates/rates/a/"+currency+"/"+start_date+"/"+end_date+"/";
        ResponseEntity<ExchangeRate> responseEntity = restTemplate.getForEntity(apiUrl, ExchangeRate.class);
        ExchangeRate exchangeRate = responseEntity.getBody();

        List<Rates> rates = exchangeRate.getRates();

        double sum = 0;
        for (Rates rate : rates) {
            sum += rate.getMid();
        }

        double avarage_currency = sum / rates.size();

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        saveToDatabase(new CurrencyModel(currency, start_date, end_date, avarage_currency, Date.valueOf(localDate), Time.valueOf(localTime)));

        return avarage_currency;
    }

    public void saveToDatabase(CurrencyModel currencyModel){
        currencyRepository.save(currencyModel);
    }

    public List<CurrencyModel> getAllCurrencyHistory() {
        return currencyRepository.findAll();
    }
}
