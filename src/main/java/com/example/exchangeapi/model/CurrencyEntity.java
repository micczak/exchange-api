package com.example.exchangeapi.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@Table(name="currency_info")
public class CurrencyEntity {
    @Id
    @Column(name="code")
    private String code;

    @Column(name="currency")
    private String currency;

    @Column(name="bid")
    private BigDecimal bid;

    @Column(name="ask")
    private BigDecimal ask;

}


