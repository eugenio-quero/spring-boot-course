package com.eugenio.courses.springbootcourse.model.enums;

public enum DeploymentStatus {
	REQUESTED (0), IN_PROGRESS (1), DONE(2);

	Integer id;

	private DeploymentStatus(Integer id) {
		this.id = id;
}

	public 	Integer getId() {
		return id;
	}

}
