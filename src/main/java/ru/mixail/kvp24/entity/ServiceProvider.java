package ru.mixail.kvp24.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "service_provider")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceProvider {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID поставщика услуг

    @Column(name = "name", nullable = false)
    private String name; // Наименование поставщика услуг

    @Column(name = "bank_name", nullable = false)
    private String bankName; // Наименование банка

    @Column(name = "bank_bik", nullable = false, length = 9)
    private String bankBik; // БИК банка

    @Column(name = "account_number", nullable = false)
    private String accountNumber; // Расчетный счет

}
