package vn.homestay.domain;

import vn.homestay.common.BaseEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="room_types")
public class RoomType extends BaseEntity {
    @jakarta.validation.constraints.NotBlank
    @Column(nullable=false, unique=true, length=40)
    private String code;

    @jakarta.validation.constraints.NotBlank
    @Column(nullable=false, length=120)
    private String name;

    @jakarta.validation.constraints.NotNull @jakarta.validation.constraints.Min(1)
    @Column(nullable=false)
    private Integer capacity;

    @jakarta.validation.constraints.NotNull @jakarta.validation.constraints.Positive
    @Column(name="area_sqm", nullable=false)
    private java.math.BigDecimal areaSqm;

    @jakarta.validation.constraints.NotNull @jakarta.validation.constraints.PositiveOrZero
    @Column(name="base_price", nullable=false)
    private java.math.BigDecimal basePrice;

    @Column(columnDefinition="text")
    private String amenities;

    @Column(columnDefinition="text")
    private String description;

    public RoomType() {
    }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public java.math.BigDecimal getAreaSqm() { return areaSqm; }
    public void setAreaSqm(java.math.BigDecimal areaSqm) { this.areaSqm = areaSqm; }
    public java.math.BigDecimal getBasePrice() { return basePrice; }
    public void setBasePrice(java.math.BigDecimal basePrice) { this.basePrice = basePrice; }
    public String getAmenities() { return amenities; }
    public void setAmenities(String amenities) { this.amenities = amenities; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
