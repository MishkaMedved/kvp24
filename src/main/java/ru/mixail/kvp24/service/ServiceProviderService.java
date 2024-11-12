package ru.mixail.kvp24.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mixail.kvp24.repository.ServiceProviderRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ServiceProviderService {
    private final ServiceProviderRepository serviceProviderRepository;
}
