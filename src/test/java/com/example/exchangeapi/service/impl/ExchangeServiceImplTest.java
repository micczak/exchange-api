package com.example.exchangeapi.service.impl;

import com.example.exchangeapi.model.CurrencyEntity;
import com.example.exchangeapi.model.ExchangeResult;
import com.example.exchangeapi.model.Query;
import com.example.exchangeapi.repository.CurrencyRepository;
import com.example.exchangeapi.repository.ExchangeResultRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ExchangeServiceImplTest {

    @Mock
    private CurrencyRepository currencyRepository;

    @Mock
    private ExchangeResultRepository exchangeResultRepository;

    private ExchangeServiceImpl exchangeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        exchangeService = new ExchangeServiceImpl(currencyRepository, exchangeResultRepository);
    }

    @Test
    public void testConvert() {
        Query query = new Query();
        query.setFrom("USD");
        query.setTo("EUR");
        query.setAmount(100.00);

        CurrencyEntity fromCurrencyEntity = new CurrencyEntity();
        fromCurrencyEntity.setCode("USD");
        fromCurrencyEntity.setAsk(BigDecimal.valueOf(1.2));

        CurrencyEntity toCurrencyEntity = new CurrencyEntity();
        toCurrencyEntity.setCode("EUR");
        toCurrencyEntity.setBid(BigDecimal.valueOf(0.9));

        when(currencyRepository.findById("USD")).thenReturn(Optional.of(fromCurrencyEntity));
        when(currencyRepository.findById("EUR")).thenReturn(Optional.of(toCurrencyEntity));

        ExchangeResult result = exchangeService.convert(query);

        assertTrue(result.isSuccess(), "Conversion should be successful");
        assertEquals(query, result.getQuery(), "Query in result should be equal to the original query");
        assertEquals(133.33, result.getResult(), 0.01, "Conversion result should be correct");

        ArgumentCaptor<String> currencyCaptor = ArgumentCaptor.forClass(String.class);
        verify(currencyRepository, times(2)).findById(currencyCaptor.capture());
        verify(exchangeResultRepository, times(1)).save(any());

        assertEquals("USD", currencyCaptor.getAllValues().get(0), "First queried currency should be 'USD'");
        assertEquals("EUR", currencyCaptor.getAllValues().get(1), "Second queried currency should be 'EUR'");
    }
}
