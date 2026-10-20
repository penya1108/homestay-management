package vn.homestay.domain;

import vn.homestay.common.BaseEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="vouchers")
public class Voucher extends BaseEntity {
    @jakarta.validation.constraints.NotBlank
    @Column(nullable=false, unique=true, length=50)
    private String code;

    @jakarta.validation.constraints.NotBlank
    @Column(nullable=false, length=160)
    private String name;

    @jakarta.validation.constraints.NotBlank
    @Column(name="discount_type", nullable=false, length=20)
    private String discountType;

    @jakarta.validation.constraints.NotNull @jakarta.validation.constraints.Positive
    @Column(name="discount_value", nullable=false)
    private java.math.BigDecimal discountValue;

    @jakarta.validation.constraints.NotNull
    @Column(name="start_date", nullable=false)
    private java.time.LocalDate startDate;

    @jakarta.validation.constraints.NotNull
    @Column(name="end_date", nullable=false)
    private java.time.LocalDate endDate;

    @Column(name="usage_limit", nullable=false)
    private Integer usageLimit;

    @Column(name="used_count", nullable=false)
    private Integer usedCount;

    @Column(columnDefinition="text")
    private String description;

    public Voucher() {
        this.usageLimit = 1;
        this.usedCount = 0;
    }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDiscountType() { return discountType; }
    public void setDiscountType(String discountType) { this.discountType = discountType; }
    public java.math.BigDecimal getDiscountValue() { return discountValue; }
    public void setDiscountValue(java.math.BigDecimal discountValue) { this.discountValue = discountValue; }
    public java.time.LocalDate getStartDate() { return startDate; }
    public void setStartDate(java.time.LocalDate startDate) { this.startDate = startDate; }
    public java.time.LocalDate getEndDate() { return endDate; }
    public void setEndDate(java.time.LocalDate endDate) { this.endDate = endDate; }
    public Integer getUsageLimit() { return usageLimit; }
    public void setUsageLimit(Integer usageLimit) { this.usageLimit = usageLimit; }
    public Integer getUsedCount() { return usedCount; }
    public void setUsedCount(Integer usedCount) { this.usedCount = usedCount; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
