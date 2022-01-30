package com.udemy.course.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.udemy.course.entities.enums.OrderStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_order")
@Data
@NoArgsConstructor
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/* Essa anotação toda dentro do JsonFormat serve para garantir que o formato da data 
	 * será instanciado no formato UTC - ISO 8601
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private Integer orderStatus;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	/*
	 * Foi necessário criar o construtor com argumentos por conta de como foi criada a 
	 * classe ENUM OrderStatus (explicação sobre isso dentro da classe)
	 * A criação do método get e set do atributo orderStatus também é pelo mesmo motivo, para ser possível 
	 * receber do construtor um objeto do tipo OrderStatus, e setar no banco de dados um objeto
	 * OrderStatus do tipo Integer como está sendo declarado o atributo orderStatus da classe Order.
	 */
	
	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}
	
	// Recebendo um Integer e pegando o OrderStatus correspondente a esse Integer recebido
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}
	
	// Setando o código correspondente ao OrderStatus recebido como parâmetro do método.
	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
		
	}
	
	
	

}
