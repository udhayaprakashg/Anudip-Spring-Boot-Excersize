package com.jojuskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jojuskills.entity.Customer;
import com.jojuskills.exception.CustomerNotFoundException;
import com.jojuskills.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	public Customer getCustomerById(int id) {
		return customerRepo.findById(id).orElseThrow(
				() -> new CustomerNotFoundException("No customer exist with this id: " + id));
	}

	public void deleteCustomer(int id) {
		customerRepo.findById(id).orElseThrow(()-> new CustomerNotFoundException("No customer id"+id));
		customerRepo.deleteById(id);
	}

	public Customer updaCustomer(int id, Customer customer){
		Customer exisitigCustomer = customerRepo.findById(id).orElseThrow(()-> new CustomerNotFoundException("No customer id"+id));
		exisitigCustomer.setName(customer.getName());
		exisitigCustomer.setAddress(customer.getAddress());
		customerRepo.save(exisitigCustomer);
		return exisitigCustomer;
	}


}
