package org.example.goldproduct.Controller;

import org.example.goldproduct.Model.Customer;
import org.example.goldproduct.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    private ResponseEntity<?> addCustomer(@ModelAttribute Customer customer){
        try{
            Customer customer1=customerService.addCustomer(customer);
            return new ResponseEntity<>(customer1, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/customers")
    private List<Customer> getCustomers(){
          return customerService.getAllCustomers();
    }
}
