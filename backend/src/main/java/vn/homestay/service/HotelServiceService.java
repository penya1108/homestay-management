package vn.homestay.service;

import vn.homestay.common.BaseEntity;
import vn.homestay.repository.HotelServiceRepository;
import vn.homestay.domain.HotelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class HotelServiceService {
    private final HotelServiceRepository repository;
    public HotelServiceService(HotelServiceRepository repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<HotelService> findAll() { return repository.findAllByDeletedAtIsNull(); }

    @Transactional(readOnly = true)
    public HotelService findById(Long id) {
        HotelService entity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy dữ liệu ID " + id));
        if (entity.getDeletedAt() != null) throw new IllegalArgumentException("Bản ghi đã ngừng hoạt động");
        return entity;
    }

    public HotelService create(HotelService entity) { entity.setDeletedAt(null); return repository.save(entity); }

    public HotelService update(Long id, HotelService input) {
        HotelService current = findById(id);
        copy(input, current);
        return repository.save(current);
    }

    public void delete(Long id) {
        HotelService current = findById(id);
        current.setDeletedAt(LocalDateTime.now());
        repository.save(current);
    }

    private void copy(HotelService source, HotelService target) {
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setCategory(source.getCategory());
        target.setUnit(source.getUnit());
        target.setPrice(source.getPrice());
        target.setDescription(source.getDescription());
        target.setActive(source.getActive());
    }
}
