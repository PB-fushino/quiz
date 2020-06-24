package jp.co.plan_b.training.infrastructure.entity;

import lombok.Data;

@Data
public class Answer {

  private Integer id;
  private Integer uid;
  private String username;
  private Integer qid;
  private Integer answer;
  private Integer time;

}
