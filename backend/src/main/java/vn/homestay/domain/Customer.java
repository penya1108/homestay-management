package vn.homestay.domain;

import vn.homestay.common.BaseEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="customers")
public class Customer extends BaseEntity {
    @Column(name="identity_number", unique=true, length=32)
    private String identityNumber;

    @jakarta.validation.constraints.NotBlank
    @Column(name="full_name", nullable=false, length=160)
    private String fullName;

    @Column(name="date_of_birth")
    private java.time.LocalDate dateOfBirth;

    @Column(length=20)
    private String gender;

    @Column(length=80)
    private String nationality;

    @Column(length=160)
    private String email;

    @Column(length=32)
    private String phone;

    @Column(columnDefinition="text")
    private String address;

    @Column(name="loyalty_points", nullable=false)
    private Long loyaltyPoints;

    @Column(name="membership_level", nullable=false, length=20)
    private String membershipLevel;

    public Customer() {
        this.loyaltyPoints = 0L;
        this.membershipLevel = "STANDARD";
    }
    public String getIdentityNumber() { return identityNumber; }
    public void setIdentityNumber(String identityNumber) { this.identityNumber = identityNumber; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public java.time.LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(java.time.LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Long getLoyaltyPoints() { return loyaltyPoints; }
    public void setLoyaltyPoints(Long loyaltyPoints) { this.loyaltyPoints = loyaltyPoints; }
    public String getMembershipLevel() { return membershipLevel; }
    public void setMembershipLevel(String membershipLevel) { this.membershipLevel = membershipLevel; }
}
