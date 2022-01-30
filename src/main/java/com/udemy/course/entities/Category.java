package com.udemy.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "tb_category")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	// Anotação para mapear a coleção na outra classe do relacionamento muitos para muitos
	@ManyToMany(mappedBy = "categories")
	@JsonIgnore
	private Set<Product> products = new HashSet<>();

	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Set<Product> getProducts() {
		return products;
	}
	
	
	
	
}
