package com.coin.hub.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommonMarketServiceTest {

    @Mock
    private BithumbMarketService bithumbMarketService;
    @Mock
    private UpbitMarketService upbitMarketService;

    private CommonMarketService commonMarketService;

    @BeforeEach
    void setUp() {
        commonMarketService= new CommonMarketService(
                Map.of("bithumbMarketService", bithumbMarketService,
                        "upbitMarketService", upbitMarketService)
        );
    }

    @Test
    void getPriceTest() {
        // given
        double testAmount = 123.456;
        String testCoin = "testCoin";
        when(bithumbMarketService.getCoinCurrentPrice(testCoin)).thenReturn(testAmount);
        when(upbitMarketService.getCoinCurrentPrice(testCoin)).thenReturn(testAmount);

        // expected
        assertThat(testAmount).isEqualTo(commonMarketService.getPrice("bithumb", testCoin));
        assertThat(testAmount).isEqualTo(commonMarketService.getPrice("upbit", testCoin));
    }

    @Test
    void getMarketServiceTest() {
        //given
        Map<String, MarketService> marketServices = new HashMap<>();
        marketServices.put("bithumbMarketService", bithumbMarketService);
        marketServices.put("upbitMarketService", upbitMarketService);

        // expected
        assertThat(bithumbMarketService).isEqualTo(CommonMarketService.getMarketService(marketServices, "bithumb"));
        assertThat(bithumbMarketService).isEqualTo(CommonMarketService.getMarketService(marketServices, "Bithumb"));
        assertThat(bithumbMarketService).isEqualTo(CommonMarketService.getMarketService(marketServices, "BITHUMB"));
        assertThat(bithumbMarketService).isEqualTo(CommonMarketService.getMarketService(marketServices, "bithuMB"));
        assertThat(upbitMarketService).isEqualTo(CommonMarketService.getMarketService(marketServices, "upbit"));
        assertThat(upbitMarketService).isEqualTo(CommonMarketService.getMarketService(marketServices, "Upbit"));
        assertThat(upbitMarketService).isEqualTo(CommonMarketService.getMarketService(marketServices, "UPBIT"));
        assertThat(upbitMarketService).isEqualTo(CommonMarketService.getMarketService(marketServices, "upbiT"));
    }
}