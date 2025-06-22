package com.pd.currency.converter.controller;

import com.pd.currency.converter.dto.ConvertedCurrency;
import com.pd.currency.converter.service.CurrencyConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {

    private final CurrencyConversionService currencyConversionService;

    CurrencyConversionController(CurrencyConversionService currencyConversionService) {
        this.currencyConversionService = currencyConversionService;
    }

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity convertCurrency(@PathVariable String from,
                                          @PathVariable String to,
                                          @PathVariable BigDecimal quantity) {
        ConvertedCurrency convertedCurrency = currencyConversionService.convertCurrency(from, to, quantity);
        if(convertedCurrency == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(convertedCurrency);
        }
    }

}
