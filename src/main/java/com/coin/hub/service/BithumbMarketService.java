package com.coin.hub.service;

import com.coin.hub.feigh.BithumbFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<String> getCoins() {
        // API 활용해서 가져오기
        List<String> result = new ArrayList<>();
        bithumbFeignClient.getAssetStatus().getData().forEach((k, v) -> {
            if (v.getWithdrawal_status() == 1 && v.getDeposit_status() == 1) {
                result.add(k.toUpperCase());
            }
        });
        return result;
    }
}
