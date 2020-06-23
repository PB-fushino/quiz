package jp.co.plan_b.training.presentation.request.user;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterUserRequest {

  @NotBlank(message = "nameが入力されていません")
  public String name;
}
