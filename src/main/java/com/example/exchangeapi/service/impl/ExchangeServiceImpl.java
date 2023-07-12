package com.example.exchangeapi.service.impl;

import com.example.exchangeapi.model.CurrencyEntity;
import com.example.exchangeapi.model.ExchangeResult;
import com.example.exchangeapi.model.ExchangeResultEntity;
import com.example.exchangeapi.model.Query;
import com.example.exchangeapi.repository.CurrencyRepository;
import com.example.exchangeapi.repository.ExchangeResultRepository;
import com.example.exchangeapi.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {

    private final CurrencyRepository currencyRepository;
    private final ExchangeResultRepository exchangeResultRepository;
    @Override
    @Transactional
    public ExchangeResult convert(Query query) {
        ExchangeResult result = new ExchangeResult();

        Optional<CurrencyEntity> fromCurrencyEntity = currencyRepository.findById(query.getFrom());
        Optional<CurrencyEntity> toCurrencyEntity = currencyRepository.findById(query.getTo());

        if (fromCurrencyEntity.isPresent() && toCurrencyEntity.isPresent()) {
            BigDecimal fromRate = fromCurrencyEntity.get().getAsk();
            BigDecimal toRate = toCurrencyEntity.get().getBid();

            BigDecimal fromAmount = BigDecimal.valueOf(query.getAmount());
            BigDecimal toAmount;

            BigDecimal intermediateAmount = fromAmount.multiply(fromRate);

            toAmount = intermediateAmount.divide(toRate, 4, RoundingMode.HALF_UP);

            result.setResult(toAmount.doubleValue());
            result.setSuccess(true);
            result.setQuery(query);

            ExchangeResultEntity exchangeResultEntity = new ExchangeResultEntity();
            exchangeResultEntity.setFromCurrency(query.getFrom());
            exchangeResultEntity.setToCurrency(query.getTo());
            exchangeResultEntity.setFromAmount(fromAmount);
            exchangeResultEntity.setToAmount(toAmount);
            exchangeResultEntity.setExchangeDate(LocalDateTime.now());
            exchangeResultRepository.save(exchangeResultEntity);
        } else {
            result.setSuccess(false);
        }
        return result;
    }





}
