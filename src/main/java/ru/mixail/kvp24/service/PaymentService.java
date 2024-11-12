package ru.mixail.kvp24.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mixail.kvp24.entity.Payment;
import ru.mixail.kvp24.entity.ServiceConsumer;
import ru.mixail.kvp24.entity.ServiceProvider;
import ru.mixail.kvp24.repository.PaymentRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Transactional
    public Payment createPayment(ServiceConsumer consumer, BigDecimal amount, LocalDate paymentDate) {
        Payment payment = new Payment();
        payment.setServiceConsumer(consumer);
        payment.setAmount(amount);
        payment.setPaymentDate(paymentDate);
        payment.setTransferred(false);
        return paymentRepository.save(payment);
    }

    public List<Payment> getUntransferredPayments(ServiceProvider provider) {
        return paymentRepository.findByServiceConsumerServiceProviderAndIsTransferredFalse(provider);
    }
}
