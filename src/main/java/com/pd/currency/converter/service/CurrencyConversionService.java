package com.pd.currency.converter.service;

import com.pd.currency.converter.dto.ConvertedCurrency;

import java.math.BigDecimal;

public interface CurrencyConversionService {
    ConvertedCurrency convertCurrency(String from, String to, BigDecimal quantity);
}
