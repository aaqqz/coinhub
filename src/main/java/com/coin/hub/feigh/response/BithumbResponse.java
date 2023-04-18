package com.coin.hub.feigh.response;

import lombok.Getter;

@Getter
public class BithumbResponse<T> {

    private String status;

    private T data;
}
