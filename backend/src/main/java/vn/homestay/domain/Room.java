package vn.homestay.domain;

import vn.homestay.common.BaseEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="rooms")
public class Room extends BaseEntity {
    @jakarta.validation.constraints.NotBlank
    @Column(name="room_number", nullable=false, unique=true, length=40)
    private String roomNumber;

    @Column(name="floor_number", nullable=false)
    private Integer floorNumber;

    @jakarta.validation.constraints.NotNull
    @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="room_type_id", nullable=false)
    private RoomType roomType;

    @jakarta.validation.constraints.NotNull @jakarta.validation.constraints.PositiveOrZero
    @Column(name="price_per_night", nullable=false)
    private java.math.BigDecimal pricePerNight;

    @Column(nullable=false, length=24)
    private String status;

    public Room() {
        this.floorNumber = 1;
        this.status = "AVAILABLE";
        this.status = "AVAILABLE";
    }
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    public Integer getFloorNumber() { return floorNumber; }
    public void setFloorNumber(Integer floorNumber) { this.floorNumber = floorNumber; }
    public RoomType getRoomType() { return roomType; }
    public void setRoomType(RoomType roomType) { this.roomType = roomType; }
    public java.math.BigDecimal getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(java.math.BigDecimal pricePerNight) { this.pricePerNight = pricePerNight; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
