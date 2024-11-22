package ru.mixail.kvp24.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.mixail.kvp24.entity.Payment;
import ru.mixail.kvp24.entity.ServiceConsumer;
import ru.mixail.kvp24.service.PaymentService;
import ru.mixail.kvp24.service.ServiceConsumerService;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final ServiceConsumerService serviceConsumerService;

    @PostMapping("/create")
    public ResponseEntity<Payment> createPayment(@RequestParam Long consumerId, @RequestParam double amount,
                                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate paymentDate) {
        // Загрузить ServiceConsumer из базы данных
        ServiceConsumer consumer = serviceConsumerService.getServiceConsumerById(consumerId);

        Payment payment = paymentService.createPayment(consumer, amount, paymentDate);
        return ResponseEntity.ok(payment);
    }

    @GetMapping("/getSum")
    public ResponseEntity<Double> getSum(@RequestParam Long providerId) {
        double sum = paymentService.getSumPaymentsForProvider(providerId);
        return ResponseEntity.ok(sum);
    }

}
