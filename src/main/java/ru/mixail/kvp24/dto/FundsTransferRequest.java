package ru.mixail.kvp24.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FundsTransferRequest {
    private Long consumerId;
    private BigDecimal targetAmount;
}

