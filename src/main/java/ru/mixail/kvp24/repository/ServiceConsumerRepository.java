package ru.mixail.kvp24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mixail.kvp24.entity.ServiceConsumer;

@Repository
public interface ServiceConsumerRepository extends JpaRepository<ServiceConsumer, Long> {
    ServiceConsumer findByName(String name);
}