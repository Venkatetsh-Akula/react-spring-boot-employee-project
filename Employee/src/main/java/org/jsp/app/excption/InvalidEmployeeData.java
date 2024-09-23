package org.jsp.app.excption;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InvalidEmployeeData extends RuntimeException {
	private String message;
	public InvalidEmployeeData() {
		super("Invalid Employee Data");
	}
	public InvalidEmployeeData(String message) {
		this.message=message;
	}
	@Override
	public String toString() {
		return this.message;
	}
}
