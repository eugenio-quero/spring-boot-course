package com.eugenio.courses.springbootcourse.model.enums;

public enum BranchType {
	FRONTEND (0), BACKEND (1);

	Integer id;

	private BranchType(Integer id) {
		this.id = id;
}

	public 	Integer getId() {
		return id;
	}

}
