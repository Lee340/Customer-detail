package com.boram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.boram.entity.CustomerDetail;
import com.boram.service.CustomerDetailService;



@Controller
public class CustomerDetailController {
	
	@Autowired
	private CustomerDetailService customerDetailService;
	
	@RequestMapping("/")
	public ModelAndView getCustomerInputPage() {
		
		return new ModelAndView("InputCustomerId");
	}
	
	@RequestMapping("/checkCustomerDetail")
	public ModelAndView checkCustomerDetailController(@RequestParam("customerId") int customerId) {
		ModelAndView modelAndView=new ModelAndView();
		
		List<CustomerDetail> customerDetails=customerDetailService.getCustomerDetailByCustomerId(customerId);
//		System.out.println(customerDetails);
		
		modelAndView.addObject("customerDetails", customerDetails);
		modelAndView.addObject("CustomerId", customerId);
		modelAndView.setViewName("ShowCustomerDetail");
		return modelAndView;
	}
}
