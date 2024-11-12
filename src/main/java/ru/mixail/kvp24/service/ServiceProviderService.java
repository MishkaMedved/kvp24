package ru.mixail.kvp24.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mixail.kvp24.entity.ServiceProvider;
import ru.mixail.kvp24.repository.ServiceProviderRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ServiceProviderService {

    private final ServiceProviderRepository serviceProviderRepository;

    public List<ServiceProvider> getAllServiceProviders() {
        return serviceProviderRepository.findAll();
    }

    public ServiceProvider getServiceProviderById(long id) {
        return serviceProviderRepository.findById(id).orElse(null);
    }

    public ServiceProvider getServiceProviderByName(String name) {
        return serviceProviderRepository.findByName(name);
    }

    @Transactional
    public void saveServiceProvider(ServiceProvider serviceProvider) {
        serviceProviderRepository.save(serviceProvider);
    }

    @Transactional
    public void updateServiceProvider(long id, ServiceProvider updatedServiceProvider) {
        updatedServiceProvider.setId(id);
        serviceProviderRepository.save(updatedServiceProvider);
    }

    @Transactional
    public void deleteServiceProvider(long id) {
        serviceProviderRepository.deleteById(id);
    }

}
