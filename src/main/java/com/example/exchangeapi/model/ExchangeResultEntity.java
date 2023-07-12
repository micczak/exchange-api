package com.example.exchangeapi.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="exchange_results")
public class ExchangeResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="from_currency")
    private String fromCurrency;

    @Column(name="to_currency")
    private String toCurrency;

    @Column(name="from_amount")
    private BigDecimal fromAmount;

    @Column(name="to_amount")
    private BigDecimal toAmount;

    @Column(name="exchange_date")
    private LocalDateTime exchangeDate;

}
