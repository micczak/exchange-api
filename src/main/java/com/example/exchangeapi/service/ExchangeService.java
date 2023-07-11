package com.example.exchangeapi.service;

import com.example.exchangeapi.ExchangeApiApplication;
import com.example.exchangeapi.model.ExchangeResult;
import com.example.exchangeapi.model.Query;
import com.example.exchangeapi.repository.ExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface ExchangeService {

    ExchangeResult convert(Query query);

}
