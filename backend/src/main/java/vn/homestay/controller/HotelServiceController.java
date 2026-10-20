package vn.homestay.controller;

import vn.homestay.domain.HotelService;
import vn.homestay.service.HotelServiceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "http://localhost:4200")
public class HotelServiceController {
    private final HotelServiceService service;
    public HotelServiceController(HotelServiceService service) { this.service = service; }

    @GetMapping public List<HotelService> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public HotelService findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public HotelService create(@Valid @RequestBody HotelService entity) { return service.create(entity); }
    @PutMapping("/<built-in function id>") public HotelService update(@PathVariable Long id, @Valid @RequestBody HotelService entity) { return service.update(id, entity); }
    @DeleteMapping("/<built-in function id>") public void delete(@PathVariable Long id) { service.delete(id); }
}
