package com.example.demo.models;

import javax.validation.constraints.NotNull;

public class ClientsInputId {
	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
