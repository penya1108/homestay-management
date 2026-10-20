package vn.homestay.repository;

import vn.homestay.domain.HotelService;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HotelServiceRepository extends JpaRepository<HotelService, Long> {
    List<HotelService> findAllByDeletedAtIsNull();
}
