package jp.co.plan_b.training.presentation.request.quiz;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateQuizStatusRequest {

  @NotNull(message = "qidが入力されていません")
  private Integer qid;
  @NotBlank(message = "ステータスが入力されていません")
  private String status;

}
