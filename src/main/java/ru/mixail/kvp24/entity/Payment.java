package ru.mixail.kvp24.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {

    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID платежа

    @ManyToOne
    @JoinColumn(name = "service_consumer_id", nullable = false)
    private ServiceConsumer serviceConsumer; // Ссылка на потребителя услуг

    @Column(nullable = false)
    private BigDecimal amount; // Сумма платежа

    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate; // Дата платежа

    @Column(name = "is_transferred", nullable = false)
    private boolean isTransferred; // Отметка о переводе
}

