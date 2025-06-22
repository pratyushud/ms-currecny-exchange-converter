package com.pd.currency.converter.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
public class ConvertedCurrency {
    private String from;
    private String to;
    private BigDecimal quantity;
    private BigDecimal rate;
    private BigDecimal convertedValue;
}
