package jp.co.plan_b.training.presentation.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jp.co.plan_b.training.application.service.user.UserService;
import jp.co.plan_b.training.model.dto.ErrorDetail;
import jp.co.plan_b.training.model.dto.ErrorResponse;
import jp.co.plan_b.training.model.dto.User;
import jp.co.plan_b.training.model.dto.Users;
import jp.co.plan_b.training.presentation.request.user.RegisterUserRequest;
import jp.co.plan_b.training.presentation.response.ResponseHeader;

@RestController
@CrossOrigin
public class UserController {

  @Autowired
  UserService userService;

  @Autowired
  ResponseHeader responseHeader;

  Logger logger = LoggerFactory.getLogger(UserController.class);

  @GetMapping("/users")
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

  @PostMapping("/login")
  public ResponseEntity<?> login(HttpServletRequest request, HttpServletResponse response,
      @RequestBody RegisterUserRequest registerRequest) {
    String name = registerRequest.getName();
    userService.registerUser(name);
    User paneler = userService.getUserByname(registerRequest.getName());

    return ResponseEntity.ok().headers(responseHeader.getStandardGetHeader()).body(paneler);
  }

  // @RequestMapping(value = "/wait", method = RequestMethod.POST)
  // @ResponseBody
  // public String wait(HttpServletRequest request, HttpServletResponse response,
  // @ModelAttribute User json) {
  // response.setHeader("Access-Control-Allow-Origin", "*");
  // response.setHeader("Access-Control-Allow-Methods", "GET, POST,PUT,DELETE,OPTIONS");
  // // jsonログインページで入力したユーザーネームとパスワードが入っている
  // // String username = json.getUsername();
  // // String password = json.getPassword();
  // // boolean valid = password.equals(userService.getUserPassword(username));//パスの確認
  // return "待機";
  // }
}
