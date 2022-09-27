package com.unitycourse.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	//construtor do code
	private OrderStatus (int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	// converter valor numerico para tipo enum
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			//verificar se o valor tem na classe enum
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}

}
