package com.boram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Customer {

	private int detailId;
	
	private int customerId;
	private int shareId;
	private String shareType;
	private int quantity;
}
