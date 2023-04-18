package com.coin.hub.feigh;

import com.coin.hub.feigh.response.BithumbResponse;
import com.coin.hub.model.BithumbCoinPrice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bithumb", url = "https://api.bithumb.com/public")
public interface BithumbFeignClient {

    @GetMapping("/ticker/{coin}")
    BithumbResponse<BithumbCoinPrice> getCoinPrice(@PathVariable("coin") String coin);
}
