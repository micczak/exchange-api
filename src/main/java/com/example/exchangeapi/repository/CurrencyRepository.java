package com.example.exchangeapi.repository;

import com.example.exchangeapi.model.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, String> {
//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="5000")})
}