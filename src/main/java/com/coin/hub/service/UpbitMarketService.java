package com.coin.hub.service;

import com.coin.hub.feigh.UpbitFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class UpbitMarketService implements MarketService {

    private final UpbitFeignClient upbitFeignClient;

    @Override
    public double getCoinCurrentPrice(String coin) {
        return upbitFeignClient.getCoinPrice("KRW-" + coin.toUpperCase())
                .get(0)
                .getTrade_price();
    }
}

