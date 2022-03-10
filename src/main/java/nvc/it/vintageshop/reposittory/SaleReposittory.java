package nvc.it.vintageshop.reposittory;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import nvc.it.vintageshop.model.Sale;

public interface SaleReposittory extends MongoRepository<Sale, String> {
    public List<Sale> findByNameContaining(String name);
}
