package vn.homestay.repository;

import vn.homestay.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findAllByDeletedAtIsNull();
}
