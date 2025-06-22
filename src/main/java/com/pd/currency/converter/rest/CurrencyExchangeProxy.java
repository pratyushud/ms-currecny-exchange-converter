package com.pd.currency.converter.rest;

import com.pd.currency.converter.dto.CurrencyExchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "exchange-service", url = "${EXCHANGE_SERVICE_URI:localhost}:8000/")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyExchange getCurrencyExchange(@PathVariable String from, @PathVariable String to);
}
