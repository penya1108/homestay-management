package vn.homestay.service;

import vn.homestay.common.BaseEntity;
import vn.homestay.repository.BookingRepository;
import vn.homestay.domain.Booking;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class BookingService {
    private final BookingRepository repository;
    public BookingService(BookingRepository repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<Booking> findAll() { return repository.findAllByDeletedAtIsNull(); }

    @Transactional(readOnly = true)
    public Booking findById(Long id) {
        Booking entity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy dữ liệu ID " + id));
        if (entity.getDeletedAt() != null) throw new IllegalArgumentException("Bản ghi đã ngừng hoạt động");
        return entity;
    }

    public Booking create(Booking entity) { entity.setDeletedAt(null); return repository.save(entity); }

    public Booking update(Long id, Booking input) {
        Booking current = findById(id);
        copy(input, current);
        return repository.save(current);
    }

    public void delete(Long id) {
        Booking current = findById(id);
        current.setDeletedAt(LocalDateTime.now());
        repository.save(current);
    }

    private void copy(Booking source, Booking target) {
        target.setBookingCode(source.getBookingCode());
        target.setCustomer(source.getCustomer());
        target.setRoom(source.getRoom());
        target.setCheckInDate(source.getCheckInDate());
        target.setCheckOutDate(source.getCheckOutDate());
        target.setGuestCount(source.getGuestCount());
        target.setStatus(source.getStatus());
        target.setDeposit(source.getDeposit());
        target.setRoomTotal(source.getRoomTotal());
        target.setServiceTotal(source.getServiceTotal());
        target.setDiscountTotal(source.getDiscountTotal());
        target.setTaxTotal(source.getTaxTotal());
        target.setGrandTotal(source.getGrandTotal());
    }
}
