package com.example.exchangeapi.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class ExchangeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private CurrencyEntity fromCurrency;

    @ManyToOne
    private CurrencyEntity toCurrency;

    private BigDecimal fromAmount;
    private BigDecimal toAmount;
    private LocalDateTime exchangeDate;
}