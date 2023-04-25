package com.coin.hub.controller;

import com.coin.hub.service.CommonMarketService;
import com.coin.hub.service.MarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MarketController {

    private final CommonMarketService commonMarketService;
    private final Map<String, MarketService> marketServices;

    // 코인의 최근 가격 : 어떤 마켓, 어떤 코인 인지
    @GetMapping("/price")
    public double getPrice(@RequestParam String market, @RequestParam String coin) {

        return commonMarketService.getPrice(market, coin);
    }

    @GetMapping("/coins")
    public List<String> getCoins(@RequestParam String market) {
        return CommonMarketService.getMarketService(marketServices, market).getCoins();
    }

    @GetMapping("/common-coins")
    public List<String> getCommonCoins(@RequestParam String fromMarket, @RequestParam String toMarket) {
        return commonMarketService.getCommonCoin(fromMarket, toMarket);
    }
}
