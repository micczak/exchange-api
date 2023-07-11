package com.example.exchangeapi.service.impl;


import com.example.exchangeapi.model.ExchangeResult;
import com.example.exchangeapi.model.Query;
import com.example.exchangeapi.repository.CurrencyRepository;
import com.example.exchangeapi.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {

    private final CurrencyRepository currencyRepository;


    @Override
    @Transactional
    public ExchangeResult convert(Query query) {
       return null;
    }
}
