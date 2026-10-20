package vn.homestay.service;

import vn.homestay.common.BaseEntity;
import vn.homestay.repository.CustomerRepository;
import vn.homestay.domain.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CustomerService {
    private final CustomerRepository repository;
    public CustomerService(CustomerRepository repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<Customer> findAll() { return repository.findAllByDeletedAtIsNull(); }

    @Transactional(readOnly = true)
    public Customer findById(Long id) {
        Customer entity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy dữ liệu ID " + id));
        if (entity.getDeletedAt() != null) throw new IllegalArgumentException("Bản ghi đã ngừng hoạt động");
        return entity;
    }

    public Customer create(Customer entity) { entity.setDeletedAt(null); return repository.save(entity); }

    public Customer update(Long id, Customer input) {
        Customer current = findById(id);
        copy(input, current);
        return repository.save(current);
    }

    public void delete(Long id) {
        Customer current = findById(id);
        current.setDeletedAt(LocalDateTime.now());
        repository.save(current);
    }

    private void copy(Customer source, Customer target) {
        target.setIdentityNumber(source.getIdentityNumber());
        target.setFullName(source.getFullName());
        target.setDateOfBirth(source.getDateOfBirth());
        target.setGender(source.getGender());
        target.setNationality(source.getNationality());
        target.setEmail(source.getEmail());
        target.setPhone(source.getPhone());
        target.setAddress(source.getAddress());
        target.setLoyaltyPoints(source.getLoyaltyPoints());
        target.setMembershipLevel(source.getMembershipLevel());
    }
}
