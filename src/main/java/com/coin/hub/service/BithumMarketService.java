package com.coin.hub.service;

import org.springframework.stereotype.Service;

@Service
public class BithumMarketService implements MarketService{

    @Override
    public double getCoinCurrentPrice(String coin) {
        return 123.1;
    }
}
