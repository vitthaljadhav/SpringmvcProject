package com.me.boot.dto;

import lombok.Data;

//@Data
public class InventoryDto {

	private Long id;
	private String itemName;
	private int units;
	public InventoryDto(String itemName, int units) {
		super();
		this.itemName = itemName;
		this.units = units;
	}
	public InventoryDto() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}

	
}
