package vn.homestay.service;

import vn.homestay.common.BaseEntity;
import vn.homestay.repository.RoomTypeRepository;
import vn.homestay.domain.RoomType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class RoomTypeService {
    private final RoomTypeRepository repository;
    public RoomTypeService(RoomTypeRepository repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<RoomType> findAll() { return repository.findAllByDeletedAtIsNull(); }

    @Transactional(readOnly = true)
    public RoomType findById(Long id) {
        RoomType entity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy dữ liệu ID " + id));
        if (entity.getDeletedAt() != null) throw new IllegalArgumentException("Bản ghi đã ngừng hoạt động");
        return entity;
    }

    public RoomType create(RoomType entity) { entity.setDeletedAt(null); return repository.save(entity); }

    public RoomType update(Long id, RoomType input) {
        RoomType current = findById(id);
        copy(input, current);
        return repository.save(current);
    }

    public void delete(Long id) {
        RoomType current = findById(id);
        current.setDeletedAt(LocalDateTime.now());
        repository.save(current);
    }

    private void copy(RoomType source, RoomType target) {
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setCapacity(source.getCapacity());
        target.setAreaSqm(source.getAreaSqm());
        target.setBasePrice(source.getBasePrice());
        target.setAmenities(source.getAmenities());
        target.setDescription(source.getDescription());
    }
}
