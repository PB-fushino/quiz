package jp.co.plan_b.training.model.dto;

public class ErrorDetail {

	private Integer status;
	private String code;
	private String userMessge;
	private String devMessage;
	private String devInfo;

	public ErrorDetail(Integer status, String code, String userMessage, String devMessage, String devInfo) {
		this.status = status;
		this.code = code;
		this.userMessge = userMessage;
		this.devMessage = devMessage;
		this.devInfo = devInfo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserMessge() {
		return userMessge;
	}

	public void setUserMessge(String userMessge) {
		this.userMessge = userMessge;
	}

	public String getDevMessage() {
		return devMessage;
	}

	public void setDevMessage(String devMessage) {
		this.devMessage = devMessage;
	}

	public String getDevInfo() {
		return devInfo;
	}

	public void setDevInfo(String devInfo) {
		this.devInfo = devInfo;
	}

}
