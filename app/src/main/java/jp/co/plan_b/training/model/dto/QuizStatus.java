package jp.co.plan_b.training.model.dto;

public class QuizStatus {

	private Integer id;
	private Integer qid;
	private String  status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	public Integer getQid() {
		return qid;
	}


}
