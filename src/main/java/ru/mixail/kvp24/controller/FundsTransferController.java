package ru.mixail.kvp24.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mixail.kvp24.entity.FundsTransfer;
import ru.mixail.kvp24.entity.ServiceProvider;
import ru.mixail.kvp24.service.FundsTransferService;
import ru.mixail.kvp24.service.ServiceProviderService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("fundsTransfers")
@RequiredArgsConstructor
public class FundsTransferController {

    private final FundsTransferService fundsTransferService;
    private final ServiceProviderService serviceProviderService;

    @GetMapping
    public ResponseEntity<List<ServiceProvider>> getFundsTransfers() {
        List<ServiceProvider> providers = serviceProviderService.getAllServiceProviders();
        return ResponseEntity.ok(providers);
    }

    @PostMapping("/create")
    public ResponseEntity<FundsTransfer> createTransfer(@RequestParam Long serviceProviderId,
                                                        @RequestParam BigDecimal amount) {
        // Загрузить ServiceProvider из базы данных
        ServiceProvider provider = serviceProviderService.getServiceProviderById(serviceProviderId);

        FundsTransfer transfer = fundsTransferService.createFundsTransfer(provider, amount);
        return ResponseEntity.ok(transfer);
    }
}