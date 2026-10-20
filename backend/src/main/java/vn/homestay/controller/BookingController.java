package vn.homestay.controller;

import vn.homestay.domain.Booking;
import vn.homestay.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {
    private final BookingService service;
    public BookingController(BookingService service) { this.service = service; }

    @GetMapping public List<Booking> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public Booking findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public Booking create(@Valid @RequestBody Booking entity) { return service.create(entity); }
    @PutMapping("/<built-in function id>") public Booking update(@PathVariable Long id, @Valid @RequestBody Booking entity) { return service.update(id, entity); }
    @DeleteMapping("/<built-in function id>") public void delete(@PathVariable Long id) { service.delete(id); }
}
