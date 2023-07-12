package com.example.exchangeapi.service;

import com.example.exchangeapi.model.ExchangeResult;
import com.example.exchangeapi.model.Query;

public interface ExchangeService {
    ExchangeResult convert(Query query);
}
