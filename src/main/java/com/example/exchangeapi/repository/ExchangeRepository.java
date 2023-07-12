package com.example.exchangeapi.repository;


import com.example.exchangeapi.model.ExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<ExchangeEntity, Long> {
}

