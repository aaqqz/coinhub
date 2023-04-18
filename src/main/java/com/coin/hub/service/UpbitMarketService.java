package com.coin.hub.service;

import com.coin.hub.feigh.UpbitFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpbitMarketService implements MarketService {

    private final UpbitFeignClient upbitFeignClient;

    @Override
    public double getCoinCurrentPrice(String coin) {
        return 123.2;
    }
}

