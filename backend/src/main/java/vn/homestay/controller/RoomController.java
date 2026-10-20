package vn.homestay.controller;

import vn.homestay.domain.Room;
import vn.homestay.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
    private final RoomService service;
    public RoomController(RoomService service) { this.service = service; }

    @GetMapping public List<Room> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public Room findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public Room create(@Valid @RequestBody Room entity) { return service.create(entity); }
    @PutMapping("/<built-in function id>") public Room update(@PathVariable Long id, @Valid @RequestBody Room entity) { return service.update(id, entity); }
    @DeleteMapping("/<built-in function id>") public void delete(@PathVariable Long id) { service.delete(id); }
}
