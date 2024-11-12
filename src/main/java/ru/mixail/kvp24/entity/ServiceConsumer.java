package ru.mixail.kvp24.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "service_consumer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceConsumer {

    @Id
    @Column(name = "service_consumer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID потребителя услуг

    @ManyToOne
    @JoinColumn(name = "service_provider_id", nullable = false)
    private ServiceProvider serviceProvider; // Ссылка на поставщика услуг

    @Column(nullable = false)
    private String fullName; // ФИО потребителя

    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber; // Номер лицевого счета

}
