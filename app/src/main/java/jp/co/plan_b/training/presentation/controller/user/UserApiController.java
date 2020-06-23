package jp.co.plan_b.training.presentation.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jp.co.plan_b.training.application.service.UserService;
import jp.co.plan_b.training.model.dto.ErrorDetail;
import jp.co.plan_b.training.model.dto.ErrorResponse;
import jp.co.plan_b.training.model.dto.Users;

@RestController
@RequestMapping("/api/v1/users")
public class UserApiController {

  @Autowired
  UserService userService;

  Logger logger = LoggerFactory.getLogger(UserApiController.class);

  @GetMapping
  public ResponseEntity<?> getAllUser() {
    Users users = new Users();
    try {
      users.setUsers(userService.getAllUser());
    } catch (Throwable e) {
      logger.error(e.getMessage(), e);
      ErrorDetail errorDetail = new ErrorDetail(HttpStatus.INTERNAL_SERVER_ERROR.value(), "000",
          "問題が発生しました", "問題が発生しました", "");
      ErrorResponse errorResponse = new ErrorResponse(errorDetail);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    return ResponseEntity.ok(users);
  }

}
