package jp.co.plan_b.training.infrastructure.entity;

import java.util.List;
import lombok.Data;

@Data
public class Quizzes {

  private List<Quiz> items;

  public Quizzes(List<Quiz> quizList) {
    this.items = quizList;
  }

}
