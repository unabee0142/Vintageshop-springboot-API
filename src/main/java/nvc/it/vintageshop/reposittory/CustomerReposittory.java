package nvc.it.vintageshop.reposittory;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import nvc.it.vintageshop.model.Customer;

public interface CustomerReposittory extends MongoRepository<Customer, String> {
    public List<Customer> findByNameContaining(String name);
}
