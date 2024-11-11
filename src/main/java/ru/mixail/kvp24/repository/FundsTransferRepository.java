package ru.mixail.kvp24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mixail.kvp24.entity.FundsTransfer;

@Repository
public interface FundsTransferRepository extends JpaRepository<FundsTransfer, Long> {
}