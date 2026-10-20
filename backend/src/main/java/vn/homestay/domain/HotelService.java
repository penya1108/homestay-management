package vn.homestay.domain;

import vn.homestay.common.BaseEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="hotel_services")
public class HotelService extends BaseEntity {
    @jakarta.validation.constraints.NotBlank
    @Column(nullable=false, unique=true, length=40)
    private String code;

    @jakarta.validation.constraints.NotBlank
    @Column(nullable=false, length=160)
    private String name;

    @jakarta.validation.constraints.NotBlank
    @Column(nullable=false, length=80)
    private String category;

    @jakarta.validation.constraints.NotBlank
    @Column(nullable=false, length=40)
    private String unit;

    @jakarta.validation.constraints.NotNull @jakarta.validation.constraints.PositiveOrZero
    @Column(nullable=false)
    private java.math.BigDecimal price;

    @Column(columnDefinition="text")
    private String description;

    @Column(nullable=false)
    private Boolean active;

    public HotelService() {
        this.active = true;
    }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    public java.math.BigDecimal getPrice() { return price; }
    public void setPrice(java.math.BigDecimal price) { this.price = price; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
