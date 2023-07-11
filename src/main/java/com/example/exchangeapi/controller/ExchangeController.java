package com.example.exchangeapi.controller;

import com.example.exchangeapi.model.ExchangeResult;
import com.example.exchangeapi.model.Query;
import com.example.exchangeapi.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping("/convert")
    public ResponseEntity<ExchangeResult> convert(@RequestParam Query query){

        ExchangeResult result = exchangeService.convert(query);
       
        return null;
    }


    // TODO: 11.07.2023  wymiana walut ŁADNIE! 
}
