package com.boram.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.boram.entity.CustomerDetailList;
import com.boram.service.CustomerDetailService;

@RestController
public class CustomerDetailResource {

	@Autowired
	private CustomerDetailService customerDetailService;
	
	@GetMapping(path="/share/customers/{uId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDetailList getCustomerDetailByCostomerIdResource(@PathVariable("uId") int customerId) {
		return new CustomerDetailList(customerDetailService.getCustomerDetailByCustomerId(customerId));
	}
}
