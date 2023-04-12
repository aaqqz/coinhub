package com.coin.hub.controller;

import com.coin.hub.service.CommonMarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MarketController {

    private final CommonMarketService marketService;

    // 코인의 최근 가격 : 어떤 마켓, 어떤 코인 인지
    @GetMapping("/price")
    public double getPrice(@RequestParam String market, @RequestParam String coin) {

        return marketService.getPrice(market, coin);
    }
}
