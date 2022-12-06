package com.boram.service;

import java.util.List;

import com.boram.entity.CustomerDetail;

public interface CustomerDetailService {

	List<CustomerDetail> getCustomerDetailByCustomerId(int customerId);
}
