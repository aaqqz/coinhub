package com.coin.hub.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CommonMarketService {

    // key : bean의 이름(class 이름), value : instance
    private final Map<String, MarketService> marketServices;


    public double getPrice(String market, String coin) {

        MarketService marketService = null;

        for (String key : marketServices.keySet()) {
            if (key.substring(0, market.length()).equals(market.toLowerCase())) {
                marketService = marketServices.get(key);
                break;
            }
        }

        return marketService.getCoinCurrentPrice(coin);
    }
}
