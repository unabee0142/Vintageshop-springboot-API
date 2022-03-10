package nvc.it.vintageshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nvc.it.vintageshop.model.Product;
import nvc.it.vintageshop.reposittory.ProductReposittory;

@Service
public class ProductService {
    @Autowired
    private ProductReposittory productReposittory;

    public List<Product> getProduct(){
        return productReposittory.findAll();
    }

    public Optional<Product> getProductById(String id){
        return productReposittory.findById(id);
    }

    public List<Product> getProductByName(String name){
        return productReposittory.findByNameContaining(name);
    }

    public Product addProduct(Product product){
        return productReposittory.save(product);
    }

    public Optional<Product> updateProduct(String id, Product product){
        Product currentProduct = productReposittory.findById(id).get();
        currentProduct.setName(product.getName());
        return Optional.of(productReposittory.save(currentProduct));
    }

    public boolean deleteProduct(String id){
        try {
            productReposittory.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    } 
}