package jp.co.plan_b.training.model.dto;



public class Quiz {

	private Integer id;
	private Integer term;
	private Integer ordernumber;
	private String  problem;
	private Integer  answer;
	private String  choice_a;
	private String  choice_b;
	private String  choice_c;
	private String  choice_d;
	private Integer  is_img;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTerm() {
		return term;
	}
	public void setTerm(Integer term) {
		this.term = term;
	}
	public Integer getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(Integer ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public Integer getAnswer() {
		return answer;
	}
	public void setAnswer(Integer answer) {
		this.answer = answer;
	}
	public String getChoice_a() {
		return choice_a;
	}
	public void setChoice_a(String choice_a) {
		this.choice_a = choice_a;
	}
	public String getChoice_b() {
		return choice_b;
	}
	public void setChoice_b(String choice_b) {
		this.choice_b = choice_b;
	}
	public String getChoice_c() {
		return choice_c;
	}
	public void setChoice_c(String choice_c) {
		this.choice_c = choice_c;
	}
	public String getChoice_d() {
		return choice_d;
	}
	public void setChoice_d(String choice_d) {
		this.choice_d = choice_d;
	}
	public Integer getIs_img() {
		return is_img;
	}
	public void setIs_img(Integer is_img) {
		this.is_img = is_img;
	}



}
