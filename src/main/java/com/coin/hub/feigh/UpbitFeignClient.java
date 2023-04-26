package com.coin.hub.feigh;

import com.coin.hub.model.UpbitCoinPrice;
import com.coin.hub.model.UpbitMarketCode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "upbit", url = "https://api.upbit.com/v1")
public interface UpbitFeignClient {

    @GetMapping("/ticker")
    List<UpbitCoinPrice> getCoinPrice(@RequestParam("markets") String coin);

    @GetMapping("market/all")
    List<UpbitMarketCode> getMarketCode();
}
