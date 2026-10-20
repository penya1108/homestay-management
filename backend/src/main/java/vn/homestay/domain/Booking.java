package vn.homestay.domain;

import vn.homestay.common.BaseEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="bookings")
public class Booking extends BaseEntity {
    @jakarta.validation.constraints.NotBlank
    @Column(name="booking_code", nullable=false, unique=true, length=50)
    private String bookingCode;

    @jakarta.validation.constraints.NotNull
    @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @jakarta.validation.constraints.NotNull
    @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="room_id", nullable=false)
    private Room room;

    @jakarta.validation.constraints.NotNull
    @Column(name="check_in_date", nullable=false)
    private java.time.LocalDate checkInDate;

    @jakarta.validation.constraints.NotNull
    @Column(name="check_out_date", nullable=false)
    private java.time.LocalDate checkOutDate;

    @Column(name="guest_count", nullable=false)
    private Integer guestCount;

    @Column(nullable=false, length=24)
    private String status;

    @Column(nullable=false)
    private java.math.BigDecimal deposit;

    @Column(name="room_total", nullable=false)
    private java.math.BigDecimal roomTotal;

    @Column(name="service_total", nullable=false)
    private java.math.BigDecimal serviceTotal;

    @Column(name="discount_total", nullable=false)
    private java.math.BigDecimal discountTotal;

    @Column(name="tax_total", nullable=false)
    private java.math.BigDecimal taxTotal;

    @Column(name="grand_total", nullable=false)
    private java.math.BigDecimal grandTotal;

    public Booking() {
        this.guestCount = 1;
        this.status = "PENDING";
        this.deposit = BigDecimal.ZERO;
        this.roomTotal = BigDecimal.ZERO;
        this.serviceTotal = BigDecimal.ZERO;
        this.discountTotal = BigDecimal.ZERO;
        this.taxTotal = BigDecimal.ZERO;
        this.grandTotal = BigDecimal.ZERO;
    }
    public String getBookingCode() { return bookingCode; }
    public void setBookingCode(String bookingCode) { this.bookingCode = bookingCode; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }
    public java.time.LocalDate getCheckInDate() { return checkInDate; }
    public void setCheckInDate(java.time.LocalDate checkInDate) { this.checkInDate = checkInDate; }
    public java.time.LocalDate getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(java.time.LocalDate checkOutDate) { this.checkOutDate = checkOutDate; }
    public Integer getGuestCount() { return guestCount; }
    public void setGuestCount(Integer guestCount) { this.guestCount = guestCount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public java.math.BigDecimal getDeposit() { return deposit; }
    public void setDeposit(java.math.BigDecimal deposit) { this.deposit = deposit; }
    public java.math.BigDecimal getRoomTotal() { return roomTotal; }
    public void setRoomTotal(java.math.BigDecimal roomTotal) { this.roomTotal = roomTotal; }
    public java.math.BigDecimal getServiceTotal() { return serviceTotal; }
    public void setServiceTotal(java.math.BigDecimal serviceTotal) { this.serviceTotal = serviceTotal; }
    public java.math.BigDecimal getDiscountTotal() { return discountTotal; }
    public void setDiscountTotal(java.math.BigDecimal discountTotal) { this.discountTotal = discountTotal; }
    public java.math.BigDecimal getTaxTotal() { return taxTotal; }
    public void setTaxTotal(java.math.BigDecimal taxTotal) { this.taxTotal = taxTotal; }
    public java.math.BigDecimal getGrandTotal() { return grandTotal; }
    public void setGrandTotal(java.math.BigDecimal grandTotal) { this.grandTotal = grandTotal; }
}
