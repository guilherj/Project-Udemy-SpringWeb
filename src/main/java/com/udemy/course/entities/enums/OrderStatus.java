package com.udemy.course.entities.enums;

/*
 * Foi feita a classe Enumerada OrderStatus com valor fixo para cada status e criado construtor 
 * e os métodos getCode e valueOf, para evitar que numa possível manutenção por outro programador
 * ao adicionar um novo status, o código dos status posteriores ao novo inserido não se alterem
 * e mantenha a integridade dos dados referentes a esses status já gravados no banco de dados.
 * Assim quando for adiconar um novo status a classe ficará intuitivo que deve ser criado o status
 * com o código seguinte ao último inserido. 
 */

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}

}
