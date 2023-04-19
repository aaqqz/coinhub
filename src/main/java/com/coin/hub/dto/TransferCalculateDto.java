package com.coin.hub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class TransferCalculateDto {

    private String coin;

    private double amount;

    private Map<Double, Double> buyOrderBook;
    private Map<Double, Double> sellOrderBook;
}
