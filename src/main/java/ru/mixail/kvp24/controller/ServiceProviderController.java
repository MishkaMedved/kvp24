package ru.mixail.kvp24.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mixail.kvp24.entity.ServiceProvider;
import ru.mixail.kvp24.service.ServiceProviderService;

import java.util.List;

@RestController
@RequestMapping("serviceProviders")
@RequiredArgsConstructor
public class ServiceProviderController {

    private final ServiceProviderService serviceProviderService;

    // Получение всех поставщиков услуг
    @GetMapping
    public ResponseEntity<List<ServiceProvider>> getServiceProviders() {
        List<ServiceProvider> providers = serviceProviderService.getAllServiceProviders();
        return providers.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(providers);
    }

    // Получение поставщика услуг по ID
    @GetMapping("{id}")
    public ResponseEntity<ServiceProvider> getServiceProvider(@PathVariable("id") long id) {
        ServiceProvider provider = serviceProviderService.getServiceProviderById(id);
        return provider == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(provider);
    }

    // Создания нового поставщика услуг
    @PostMapping
    public ResponseEntity<ServiceProvider> createServiceProvider(@RequestBody ServiceProvider provider) {
        serviceProviderService.saveServiceProvider(provider);
        return ResponseEntity.status(HttpStatus.CREATED).body(provider);
    }

    // Обновление информации о поставщике услуг
    @PutMapping("/{id}")
    public ResponseEntity<ServiceProvider> updateServiceProvider(@PathVariable Long id,
                                                                 @RequestBody ServiceProvider updatedServiceProvider) {
        serviceProviderService.updateServiceProvider(id, updatedServiceProvider);
        return ResponseEntity.status(HttpStatus.OK).body(updatedServiceProvider);
    }

}
