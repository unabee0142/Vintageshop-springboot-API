package nvc.it.vintageshop.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nvc.it.vintageshop.model.Sale;
import nvc.it.vintageshop.service.SaleService;


@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    public SaleService saleService;

    @GetMapping("")
    public ResponseEntity<Object> getSale(){
        List<Sale> customers = saleService.getSale();
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search Customer Succes!");
        map.put("data", customers);
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSaleById(@PathVariable String id){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search Customer By ID Succes!");
        map.put("data", saleService.getSaleById(id));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getSaleByName(@PathVariable String name){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search Customer By Name Succes!");
        map.put("data", saleService.getSaleByName(name));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> addSale(@RequestBody Sale sale){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Add Customer Succes!");
        map.put("data", saleService.addSale(sale));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSale(@PathVariable String id, @RequestBody Sale sale){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Update Product Succes!");
        map.put("data", saleService.updateSale(id, sale));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSale(@PathVariable String id){
        HashMap<String, Object> map = new HashMap<>();
        if (!saleService.deleteSale(id)) {
            map.put("msg", "Error Delete");
            // return new ResponseEntity<Object>(map, HttpStatus.OK);
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            map.put("msg", "Delete Succes!");
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
        
    }
}
