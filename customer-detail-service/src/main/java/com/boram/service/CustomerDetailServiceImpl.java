package com.boram.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.boram.entity.Customer;
import com.boram.entity.CustomerDetail;
import com.boram.entity.CustomerList;
import com.boram.entity.Share;

@Service
public class CustomerDetailServiceImpl implements CustomerDetailService {
		
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<CustomerDetail> getCustomerDetailByCustomerId (int customerId) {
		
		List<CustomerDetail> customerDetailList = new ArrayList<CustomerDetail>();
		
		CustomerList customerList = restTemplate.getForObject("http://localhost:8084/customers/" + customerId, CustomerList.class);
		System.out.println(customerList.getCustomers());
		for(Customer customer:customerList.getCustomers()) {
			// from everyrating, picking movie ID and calling movie service
			Share share = restTemplate.getForObject("http://localhost:8082/shares/"+customer.getShareId(), Share.class);
			
			// creating movie rating object
			double totalValuation = share.getMarketPrice() * customer.getQuantity();
			CustomerDetail customerDetail = new CustomerDetail(customer.getCustomerId(), share.getShareName(), customer.getQuantity(), share.getMarketPrice(), totalValuation, customer.getShareType());
			
			//adding movie rating object in list
			customerDetailList.add(customerDetail);
		}
		System.out.println(customerDetailList);
		return customerDetailList;
	}

}
