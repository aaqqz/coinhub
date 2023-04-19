package com.coin.hub.service;

import com.coin.hub.dto.CoinBuyDto;
import com.coin.hub.dto.CoinSellDto;
import com.coin.hub.dto.TransferCalculateDto;
import com.coin.hub.view.TransferCalculateResponseView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TransferCalculateService {

    private final CommonMarketService commonMarketService;
    private final Map<String, MarketService> marketServices;

    public TransferCalculateDto calculate(String fromMarket, String toMarket, double amount) {

        // from, to : common coin
        List<String> commonCoins = commonMarketService.getCommonCoin(fromMarket, toMarket);

        MarketService fromMarketService = CommonMarketService.getCommonCoins(marketServices, fromMarket);
        MarketService toMarketService = CommonMarketService.getCommonCoins(marketServices, toMarket);

        // from 얼마에 살수있는지
        CoinBuyDto fromMarketBuyDto = fromMarketService.calculateBuy(commonCoins, amount);

        // from 이체 수수료
        Map<String, Double> fromMarketTransferFee = fromMarketService.calculateFee(commonCoins, amount);

        // to 얼마에 팔수 있는지
        CoinSellDto toMarketSellDto = toMarketService.calculateSell(commonCoins, amount);

        // 가장 높은 값을 받을수있는 코인을 선택
        String transferCoin = toMarketSellDto.getAmounts().keySet().get(0); // todo 가장 많은 현금 코인 선택

        return new TransferCalculateDto(
                transferCoin,
                toMarketSellDto.getAmounts().get(transferCoin),
                fromMarketBuyDto.getOrderBooks().get(transferCoin),
                toMarketSellDto.getOrderBooks().get(transferCoin));
    }
}
