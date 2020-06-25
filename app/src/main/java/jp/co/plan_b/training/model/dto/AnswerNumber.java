package jp.co.plan_b.training.model.dto;

import lombok.Data;

@Data
public class AnswerNumber {

  private Integer answerNumber;

  private Integer answers;

  public AnswerNumber(Integer answerNumber, Integer answers) {
    this.answerNumber = answerNumber;
    this.answers = answers;
  }
}
