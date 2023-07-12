package com.example.exchangeapi.repository;

import com.example.exchangeapi.model.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, String> {

}