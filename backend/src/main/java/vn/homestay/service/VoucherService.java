package vn.homestay.service;

import vn.homestay.common.BaseEntity;
import vn.homestay.repository.VoucherRepository;
import vn.homestay.domain.Voucher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class VoucherService {
    private final VoucherRepository repository;
    public VoucherService(VoucherRepository repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<Voucher> findAll() { return repository.findAllByDeletedAtIsNull(); }

    @Transactional(readOnly = true)
    public Voucher findById(Long id) {
        Voucher entity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy dữ liệu ID " + id));
        if (entity.getDeletedAt() != null) throw new IllegalArgumentException("Bản ghi đã ngừng hoạt động");
        return entity;
    }

    public Voucher create(Voucher entity) { entity.setDeletedAt(null); return repository.save(entity); }

    public Voucher update(Long id, Voucher input) {
        Voucher current = findById(id);
        copy(input, current);
        return repository.save(current);
    }

    public void delete(Long id) {
        Voucher current = findById(id);
        current.setDeletedAt(LocalDateTime.now());
        repository.save(current);
    }

    private void copy(Voucher source, Voucher target) {
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setDiscountType(source.getDiscountType());
        target.setDiscountValue(source.getDiscountValue());
        target.setStartDate(source.getStartDate());
        target.setEndDate(source.getEndDate());
        target.setUsageLimit(source.getUsageLimit());
        target.setUsedCount(source.getUsedCount());
        target.setDescription(source.getDescription());
    }
}
