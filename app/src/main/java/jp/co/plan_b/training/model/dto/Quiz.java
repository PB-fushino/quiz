package jp.co.plan_b.training.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Quiz {

	private Integer id;
	private Integer term;
	private Integer ordernumber;
	private String  problem;
	private String  answer;
	private String  choice_a;
	private String  choice_b;
	private String  choice_c;
	private String  choice_d;

	public Quiz() {
	}

	public String getProblem() {
		// TODO 自動生成されたメソッド・スタブ
		return problem;
	}



}
