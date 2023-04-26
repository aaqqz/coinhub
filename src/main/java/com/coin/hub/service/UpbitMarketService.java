package com.coin.hub.service;

import com.coin.hub.feigh.UpbitFeignClient;
import com.coin.hub.model.UpbitMarketCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<String> getCoins() {
        // API 활용해서 가져오기
        List<String> result = new ArrayList<>();
        upbitFeignClient.getMarketCode().forEach(k -> {
            if (k.getMarket().startsWith("KRW")) {
                result.add(k.getMarket().substring(4).toUpperCase());
            }
        });

        return result;
    }
}

