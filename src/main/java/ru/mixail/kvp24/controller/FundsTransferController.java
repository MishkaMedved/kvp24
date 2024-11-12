package ru.mixail.kvp24.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mixail.kvp24.entity.FundsTransfer;
import ru.mixail.kvp24.entity.ServiceProvider;
import ru.mixail.kvp24.service.FundsTransferService;
import ru.mixail.kvp24.service.ServiceProviderService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/funds-transfers")
@RequiredArgsConstructor
public class FundsTransferController {

    private final FundsTransferService fundsTransferService;
    private final ServiceProviderService serviceProviderService;

    @PostMapping("/create")
    public ResponseEntity<FundsTransfer> createTransfer(@RequestParam Long serviceProviderId,
                                                        @RequestParam BigDecimal amount) {
        // Загрузить ServiceProvider из базы данных
        ServiceProvider provider = serviceProviderService.getServiceProviderById(serviceProviderId);

        FundsTransfer transfer = fundsTransferService.createFundsTransfer(provider, amount);
        return ResponseEntity.ok(transfer);
    }
}