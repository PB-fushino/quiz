package jp.co.plan_b.training.presentation.request.quiz;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GetQuizRequest {

  @NotBlank(message = "ステータスが入力されていません")
  private String status;

}
