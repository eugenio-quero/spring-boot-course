package com.eugenio.courses.springbootcourse.model.enums;

public enum Environment {
	PREPRO1 (0, "Prepro1"), 
	PREPRO2 (1, "Prepro2"),
	PROD(2, "Producción");

	Integer id;
	String description;
	
	private Environment(Integer id, String desc) {
		this.id = id;
		this.description = desc;
}

	public 	Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}


}
