package jp.co.plan_b.training.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class QuizStatus {

	private Integer id;
	private Integer qid;
	private String  status;

	public QuizStatus() {
	}

	public int getQid() {
		// TODO 自動生成されたメソッド・スタブ
		return qid;
	}





}
