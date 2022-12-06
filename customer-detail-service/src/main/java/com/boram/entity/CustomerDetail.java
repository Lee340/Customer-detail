package com.boram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDetail {

	private int customerId;
	private String shareName;
	private int quatity;
	private double unitPrice;
	private double totalValuation;
	private String shareType;
}
