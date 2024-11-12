package ru.mixail.kvp24.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mixail.kvp24.entity.ServiceConsumer;
import ru.mixail.kvp24.repository.ServiceConsumerRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ServiceConsumerService {

    private final ServiceConsumerRepository serviceConsumerRepository;

    public ServiceConsumer getServiceConsumerById(long id) {
        return serviceConsumerRepository.findById(id).orElse(null);
    }

    public ServiceConsumer getServiceConsumerByName(String name) {
        return serviceConsumerRepository.findByFullName(name);
    }

    @Transactional
    public void createServiceConsumer(ServiceConsumer serviceConsumer) {
        serviceConsumerRepository.save(serviceConsumer);
    }

    @Transactional
    public void updateServiceConsumer(long id) {
        ServiceConsumer saved = getServiceConsumerById(id);
        serviceConsumerRepository.save(saved);
    }

    @Transactional
    public void deleteServiceConsumer(long id) {
        serviceConsumerRepository.deleteById(id);
    }
}
