package com.udemy.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "tb_product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Long id;
	
	@Getter @Setter private String name;
	
	@Getter @Setter private String description;
	
	@Getter @Setter private Double price;
	
	@Getter @Setter private String imgUrl;
	
	
	/*Toda essa anotação do @JoinTable é usada para mapear relacionamentos muitos para muitos,
	 * primeiro define o nome da nova tabela que vai ser criada, depois define
	 * o nome das colunas com as chaves estrangeiras de cada classe do relacionamento.
	 * 
	 * Na outra classe do relacionamento muitos para muitos tem que se fazer
	 * o mapeamento dessa anotação (ver esse mapeamento na classe Category)
	 * 
	 */
	@ManyToMany
	@JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	@Getter private Set<Category> categories = new HashSet<>();

	public Product(Long id, String name, String description, Double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
}
