package vn.homestay.controller;

import vn.homestay.domain.Customer;
import vn.homestay.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
    private final CustomerService service;
    public CustomerController(CustomerService service) { this.service = service; }

    @GetMapping public List<Customer> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public Customer findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public Customer create(@Valid @RequestBody Customer entity) { return service.create(entity); }
    @PutMapping("/<built-in function id>") public Customer update(@PathVariable Long id, @Valid @RequestBody Customer entity) { return service.update(id, entity); }
    @DeleteMapping("/<built-in function id>") public void delete(@PathVariable Long id) { service.delete(id); }
}
