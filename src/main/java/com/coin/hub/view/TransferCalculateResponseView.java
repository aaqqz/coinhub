package com.coin.hub.view;

import com.coin.hub.dto.TransferCalculateDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class TransferCalculateResponseView {

    // 코인 이름
    private String coin;

    // 최종 가격
    private double amount;

    private Map<Double, Double> buyOrderBook;

    private Map<Double, Double> sellOrderBook;

    // dto -> view
    public static TransferCalculateResponseView of(TransferCalculateDto dto) {
        return new TransferCalculateResponseView(
                dto.getCoin(),
                dto.getAmount(),
                dto.getBuyOrderBook(),
                dto.getSellOrderBook());
    }
}
