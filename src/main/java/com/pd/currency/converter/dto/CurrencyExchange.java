package com.pd.currency.converter.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CurrencyExchange {
    private int id;

    private String from;

    private String to;

    private BigDecimal rate;

    private String environment;

}
