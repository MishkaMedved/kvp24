package ru.mixail.kvp24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.mixail.kvp24.entity.Payment;
import ru.mixail.kvp24.entity.ServiceProvider;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByServiceConsumerServiceProviderAndIsTransferredFalse(ServiceProvider serviceProvider);

    @Query("SELECT p FROM Payment p WHERE p.serviceConsumer.serviceProvider.id = :providerId AND p.isTransferred = false")
    List<Payment> findByServiceProviderIdAndIsTransferredFalse(@Param("providerId") Long providerId);

}