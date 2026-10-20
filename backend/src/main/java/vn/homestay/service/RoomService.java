package vn.homestay.service;

import vn.homestay.common.BaseEntity;
import vn.homestay.repository.RoomRepository;
import vn.homestay.domain.Room;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class RoomService {
    private final RoomRepository repository;
    public RoomService(RoomRepository repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<Room> findAll() { return repository.findAllByDeletedAtIsNull(); }

    @Transactional(readOnly = true)
    public Room findById(Long id) {
        Room entity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy dữ liệu ID " + id));
        if (entity.getDeletedAt() != null) throw new IllegalArgumentException("Bản ghi đã ngừng hoạt động");
        return entity;
    }

    public Room create(Room entity) { entity.setDeletedAt(null); return repository.save(entity); }

    public Room update(Long id, Room input) {
        Room current = findById(id);
        copy(input, current);
        return repository.save(current);
    }

    public void delete(Long id) {
        Room current = findById(id);
        current.setDeletedAt(LocalDateTime.now());
        repository.save(current);
    }

    private void copy(Room source, Room target) {
        target.setRoomNumber(source.getRoomNumber());
        target.setFloorNumber(source.getFloorNumber());
        target.setRoomType(source.getRoomType());
        target.setPricePerNight(source.getPricePerNight());
        target.setStatus(source.getStatus());
    }
}
