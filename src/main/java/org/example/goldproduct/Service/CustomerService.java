package org.example.goldproduct.Service;

import org.example.goldproduct.Model.Customer;
import org.example.goldproduct.Repository.CustomerRepository;
import org.example.goldproduct.Repository.GoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
          return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
