package jp.co.plan_b.training.model.dto;

import java.util.Arrays;
import java.util.List;

public class ErrorResponse {

	private List<ErrorDetail> errors;

	public ErrorResponse(ErrorDetail... errors) {
		this.errors = Arrays.asList(errors);
	}

	public List<ErrorDetail> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorDetail> errors) {
		this.errors = errors;
	}

}
