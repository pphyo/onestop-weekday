package com.jdc.app.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	
	@CollectionTable(name = "category", joinColumns = @JoinColumn(name = "product"))
	@ElementCollection
	private List<String> categories;
	
	@MapKeyColumn(name = "price_type", length = 30)
	@CollectionTable(name = "price", joinColumns = @JoinColumn(name = "product"))
	@ElementCollection
	@MapKeyEnumerated(EnumType.STRING)
	@Column(name = "value", nullable = false)
	private Map<PriceType, Integer> prices;
	
	@CollectionTable(name = "tag", joinColumns = @JoinColumn(name = "product"))
	@ElementCollection
	private Set<String> tags;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public Map<PriceType, Integer> getPrices() {
		return prices;
	}

	public void setPrices(Map<PriceType, Integer> prices) {
		this.prices = prices;
	}
	
	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public enum PriceType {
		Retial, Wholesale, Agent
	}

}
