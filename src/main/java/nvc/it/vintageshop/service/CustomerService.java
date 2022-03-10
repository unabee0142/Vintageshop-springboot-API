package nvc.it.vintageshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nvc.it.vintageshop.model.Customer;
import nvc.it.vintageshop.reposittory.CustomerReposittory;

@Service
public class CustomerService {
    @Autowired
    private CustomerReposittory customerReposittory;
    public List<Customer> getCustomer(){
        return customerReposittory.findAll();
    }

    public Optional<Customer> getCustomerById(String id){
        return customerReposittory.findById(id);
    }

    public List<Customer> getCustomerByName(String name){
        return customerReposittory.findByNameContaining(name);
    }

    public Customer addCustomer(Customer customer){
        return customerReposittory.save(customer);
    }

    public Optional<Customer> updateCustomer(String id, Customer customer){
        Customer currentCustomer = customerReposittory.findById(id).get();
        currentCustomer.setName(customer.getName());
        currentCustomer.setEmail(customer.getEmail());
        currentCustomer.setTel(customer.getTel());
        return Optional.of(customerReposittory.save(currentCustomer));
    }

    public boolean deleteCustomer(String id){
        try {
            customerReposittory.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
