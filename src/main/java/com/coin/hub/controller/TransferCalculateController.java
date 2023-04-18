package com.coin.hub.controller;

import com.coin.hub.view.TransferCalculateResponseView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TransferCalculateController {

    @GetMapping("/transfer-calculate")
    public TransferCalculateResponseView getPrice(@RequestParam String fromMarket, @RequestParam String toMarket, @RequestParam double amount) {
        return new TransferCalculateResponseView("BTC", 123.456,
                Map.of(123D, 123D),
                Map.of(123D, 123D)
        );
    }
}
