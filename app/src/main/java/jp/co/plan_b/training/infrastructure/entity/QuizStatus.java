package jp.co.plan_b.training.infrastructure.entity;

import lombok.Data;

@Data
public class QuizStatus {

  private Integer id;
  private Integer qid;
  private String status;

}
