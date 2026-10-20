package vn.homestay.controller;

import vn.homestay.domain.RoomType;
import vn.homestay.service.RoomTypeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/room-types")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomTypeController {
    private final RoomTypeService service;
    public RoomTypeController(RoomTypeService service) { this.service = service; }

    @GetMapping public List<RoomType> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public RoomType findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public RoomType create(@Valid @RequestBody RoomType entity) { return service.create(entity); }
    @PutMapping("/<built-in function id>") public RoomType update(@PathVariable Long id, @Valid @RequestBody RoomType entity) { return service.update(id, entity); }
    @DeleteMapping("/<built-in function id>") public void delete(@PathVariable Long id) { service.delete(id); }
}
