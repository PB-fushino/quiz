package jp.co.plan_b.training.presentation.request.quiz;

import lombok.Data;

@Data
public class PostAnswerRequest {

  private Integer uid;
  private Integer qid;
  private Integer answer;
  private Integer time;

}

