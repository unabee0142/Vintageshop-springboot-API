package nvc.it.vintageshop.reposittory;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import nvc.it.vintageshop.model.Product;

public interface ProductReposittory extends MongoRepository<Product, String> {
    public List<Product> findByNameContaining(String name);
}
