package com.jojuskills.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerDto {
	
	@NotBlank(message="empty not allowed")
	@NotBlank(message="what is your name")
	@Size(min=3,max=17,message="Name must be with in 3 to 15 charcters")
	private String name;
	
	@NotBlank(message="please enter a valid address")
	@NotBlank(message="address is null")
	@Size(min=2,max=20,message="address must be with in 3 to 20 char")
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

}
