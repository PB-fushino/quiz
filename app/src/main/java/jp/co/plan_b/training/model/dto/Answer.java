package jp.co.plan_b.training.model.dto;

public class Answer {

  private Integer id;
  private Integer uid;
  private String username;
  private Integer qid;
  private Integer answer;
  private Integer time;

  public Answer() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public Integer getQid() {
    return qid;
  }

  public void setQid(Integer qid) {
    this.qid = qid;
  }

  public Integer getAnswer() {
    return answer;
  }

  public void setAnswer(Integer answer) {
    this.answer = answer;
  }

  public Integer getTime() {
    return time;
  }

  public void setTime(Integer time) {
    this.time = time;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }



}
