package ru.mixail.kvp24.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "funds_transfer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FundsTransfer {

    @Id
    @Column(name = "funds_transfer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID перевода

    @ManyToOne
    @JoinColumn(name = "service_provider_id", nullable = false)
    private ServiceProvider serviceProvider; // Ссылка на поставщика услуг

    @Column(nullable = false)
    private BigDecimal amount; // Сумма перевода

    @Column(name = "transfer_date", nullable = false)
    private LocalDate transferDate; // Дата перевода

}
