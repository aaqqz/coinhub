package com.coin.hub.feigh;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "upbit", url = "https://api.upbit.com/v1/ticker")
public interface UpbitFeignClient {
}
