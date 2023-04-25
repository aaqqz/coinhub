package com.coin.hub.service;

import java.util.List;

public interface MarketService {

    double getCoinCurrentPrice(String coin);

    List<String>  getCoins();
}
