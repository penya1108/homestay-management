package vn.homestay.controller;

import vn.homestay.domain.Voucher;
import vn.homestay.service.VoucherService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vouchers")
@CrossOrigin(origins = "http://localhost:4200")
public class VoucherController {
    private final VoucherService service;
    public VoucherController(VoucherService service) { this.service = service; }

    @GetMapping public List<Voucher> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public Voucher findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public Voucher create(@Valid @RequestBody Voucher entity) { return service.create(entity); }
    @PutMapping("/<built-in function id>") public Voucher update(@PathVariable Long id, @Valid @RequestBody Voucher entity) { return service.update(id, entity); }
    @DeleteMapping("/<built-in function id>") public void delete(@PathVariable Long id) { service.delete(id); }
}
