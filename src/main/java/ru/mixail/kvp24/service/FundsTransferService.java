package ru.mixail.kvp24.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mixail.kvp24.entity.FundsTransfer;
import ru.mixail.kvp24.entity.Payment;
import ru.mixail.kvp24.entity.ServiceProvider;
import ru.mixail.kvp24.repository.FundsTransferRepository;
import ru.mixail.kvp24.repository.PaymentRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FundsTransferService {

    private final FundsTransferRepository fundsTransferRepository;
    private final PaymentRepository paymentRepository;

    @Transactional
    public FundsTransfer createFundsTransfer(ServiceProvider serviceProvider, BigDecimal requestedAmount) {
        List<Payment> unpaidPayments = paymentRepository.findByServiceConsumerServiceProviderAndIsTransferredFalse(serviceProvider);
        BigDecimal totalAmount = BigDecimal.ZERO;
        List<Payment> selectedPayments = new ArrayList<>();

        // Выбор платежей для формирования суммы перевода
        for (Payment payment : unpaidPayments) {
            if (totalAmount.add(payment.getAmount()).compareTo(requestedAmount) > 0) break;
            selectedPayments.add(payment);
            totalAmount = totalAmount.add(payment.getAmount());
        }

        // Создаем запись о переводе
        FundsTransfer transfer = new FundsTransfer();
        transfer.setServiceProvider(serviceProvider);
        transfer.setAmount(totalAmount);
        transfer.setTransferDate(LocalDate.now());
        fundsTransferRepository.save(transfer);

        // Отмечаем выбранные платежи как переведенные
        for (Payment payment : selectedPayments) {
            payment.setTransferred(true);
            paymentRepository.save(payment);
        }

        return transfer;
    }
}
