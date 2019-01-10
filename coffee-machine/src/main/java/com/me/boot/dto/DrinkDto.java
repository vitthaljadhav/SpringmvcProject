package com.me.boot.dto;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data 
public class DrinkDto {
	
	private Long id;
	
	private String name;

	private Double cost;

	private Map<String, Integer> ingredients = new HashMap<>();
	
	private String filePath;

	public DrinkDto(String name, Double cost, Map<String, Integer> ingredients, String filePath) {
		super();
		this.name = name;
		this.cost = cost;
		this.ingredients = ingredients;
		this.filePath = filePath;
	}

	public DrinkDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Map<String, Integer> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Map<String, Integer> ingredients) {
		this.ingredients = ingredients;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	

	
}
