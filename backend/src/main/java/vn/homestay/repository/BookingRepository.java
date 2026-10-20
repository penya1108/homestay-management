package vn.homestay.repository;

import vn.homestay.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByDeletedAtIsNull();
}
