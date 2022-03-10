package nvc.it.vintageshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nvc.it.vintageshop.model.Sale;
import nvc.it.vintageshop.reposittory.SaleReposittory;

@Service
public class SaleService {
    @Autowired
    private SaleReposittory saleRepository;

    public List<Sale> getSale(){
        return saleRepository.findAll();
    }

    public Optional<Sale> getSaleById(String id){
        return saleRepository.findById(id);
    }

    public List<Sale> getSaleByName(String name){
        return saleRepository.findByNameContaining(name);
    }

    public Sale addSale(Sale sale){
        return saleRepository.save(sale);
    }

    public Optional<Sale> updateSale(String id, Sale sale){
        Sale currentSale = saleRepository.findById(id).get();
        currentSale.setName(sale.getName());
        return Optional.of(saleRepository.save(currentSale));
    }

    public boolean deleteSale(String id){
        try {
            saleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    } 
}