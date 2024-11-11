package ru.mixail.kvp24.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mixail.kvp24.repository.ServiceConsumerRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ServiceConsumerImpl {
    private final ServiceConsumerRepository serviceConsumerRepository;

}
