package com.pd.currency.converter.service;

import com.pd.currency.converter.dto.ConvertedCurrency;
import com.pd.currency.converter.dto.CurrencyExchange;
import com.pd.currency.converter.rest.CurrencyExchangeProxy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    private CurrencyExchangeProxy currencyExchangeProxy;

    CurrencyConversionServiceImpl(CurrencyExchangeProxy currencyExchangeProxy) {
        this.currencyExchangeProxy = currencyExchangeProxy;
    }

    @Override
    public ConvertedCurrency convertCurrency(String from, String to, BigDecimal quantity) {
        CurrencyExchange currencyExchange = this.currencyExchangeProxy.getCurrencyExchange(from, to);
        System.out.println(currencyExchange.getEnvironment());
        if(currencyExchange == null) {
            return null;
        }
        ConvertedCurrency convertedCurrency = ConvertedCurrency.builder()
                .from(from)
                .to(to)
                .quantity(quantity)
                .rate(currencyExchange.getRate())
                .convertedValue(currencyExchange.getRate().multiply(quantity))
                .build();

        return convertedCurrency;
    }
}
