package com.alianza.customers.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerDTO {
	private String sharedKey;
	private String name;
	private String email;
	private String phone;
	private Date startDate;
	private Date endDate;
}
