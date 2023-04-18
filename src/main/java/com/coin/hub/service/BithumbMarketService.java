package com.coin.hub.service;

import com.coin.hub.feigh.BithumbFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BithumbMarketService implements MarketService {

    private final BithumbFeignClient bithumbFeignClient;

    @Override
    public double getCoinCurrentPrice(String coin) {

        return Double.parseDouble(
                bithumbFeignClient.getCoinPrice(coin.toUpperCase() + "_KRW")
                .getData()
                .getClosing_price());
    }
}
