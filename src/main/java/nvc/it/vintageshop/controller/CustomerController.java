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

import nvc.it.vintageshop.model.Customer;
import nvc.it.vintageshop.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<Object> getCustomer(){
        List<Customer> customers = customerService.getCustomer();
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search Customer Succes!");
        map.put("data", customers);
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable String id){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search Customer By ID Succes!");
        map.put("data", customerService.getCustomerById(id));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getCustomerByName(@PathVariable String name){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search Customer By Name Succes!");
        map.put("data", customerService.getCustomerByName(name));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Add Customer Succes!");
        map.put("data", customerService.addCustomer(customer));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable String id, @RequestBody Customer customer){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Update Customer Succes!");
        map.put("data", customerService.updateCustomer(id, customer));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable String id){
        HashMap<String, Object> map = new HashMap<>();
        if (!customerService.deleteCustomer(id)) {
            map.put("msg", "Error Delete");
            // return new ResponseEntity<Object>(map, HttpStatus.OK);
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            map.put("msg", "Delete Succes!");
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
        
    }
}

