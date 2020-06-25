package jp.co.plan_b.training.model.dto;

import java.util.List;
import lombok.Data;

@Data
public class AnswerMap {

  private List<AnswerNumber> items;

  public AnswerMap(List<AnswerNumber> numbers) {
    this.items = numbers;
  }

}
