package com.coin.hub.controller;

import com.coin.hub.service.TransferCalculateService;
import com.coin.hub.view.TransferCalculateResponseView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransferCalculateController {

    private final TransferCalculateService transferCalculateService;

    @GetMapping("/transfer-calculate")
    public TransferCalculateResponseView getPrice(@RequestParam String fromMarket, @RequestParam String toMarket, @RequestParam double amount) {

        return TransferCalculateResponseView.of(transferCalculateService.calculate(fromMarket, toMarket, amount));
    }
}
