package ru.mixail.kvp24.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mixail.kvp24.entity.ServiceConsumer;
import ru.mixail.kvp24.service.ServiceConsumerService;

import java.util.List;

@RestController
@RequestMapping("serviceConsumers")
@RequiredArgsConstructor
public class ServiceConsumerController {

    private final ServiceConsumerService serviceConsumerService;

    @GetMapping
    public ResponseEntity<List<ServiceConsumer>> getServiceConsumers() {
        List<ServiceConsumer> consumers = serviceConsumerService.getAllServiceConsumers();
        return consumers.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(consumers);
    }

    @GetMapping("{id}")
    public ResponseEntity<ServiceConsumer> getServiceConsumer(@PathVariable("id") long id) {
        ServiceConsumer consumer = serviceConsumerService.getServiceConsumerById(id);
        return consumer == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(consumer);
    }

    @PostMapping
    public ResponseEntity<ServiceConsumer> createServiceConsumer(@RequestBody ServiceConsumer serviceConsumer) {
        serviceConsumerService.createServiceConsumer(serviceConsumer);
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceConsumer);
    }

    @PutMapping("{id}")
    public ResponseEntity<ServiceConsumer> updateServiceConsumer(@PathVariable("id") long id,
                                                                 @RequestBody ServiceConsumer updatedServiceConsumer) {
        serviceConsumerService.updateServiceConsumer(id, updatedServiceConsumer);
        return ResponseEntity.ok(updatedServiceConsumer);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ServiceConsumer> deleteServiceConsumer(@PathVariable("id") long id) {
        serviceConsumerService.deleteServiceConsumer(id);
        return ResponseEntity.noContent().build();
    }
}
