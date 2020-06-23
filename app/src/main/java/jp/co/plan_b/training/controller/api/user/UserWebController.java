package jp.co.plan_b.training.controller.api.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.plan_b.training.model.dto.User;
import jp.co.plan_b.training.model.service.user.UserService;

@RestController
@CrossOrigin
public class UserWebController {

	@Autowired
	UserService userService;

	Logger logger = LoggerFactory.getLogger(UserWebController.class);

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  public User login(HttpServletRequest request, HttpServletResponse response,
	        @ModelAttribute User json) {
	  response.setHeader("Access-Control-Allow-Origin", "*");
	  response.setHeader("Access-Control-Allow-Methods", "GET, POST,PUT,DELETE,OPTIONS");
	  String name = json.getName();
	  System.out.println(name);
	  userService.registerUser(name);
	  List<User> user = userService.getAllUser();
	  User paneler = userService.getUserByname(json.getName());
	  System.out.println("user"+paneler.getName());
	  for (User a:user) {
		  System.out.println(a.getName());
	  }

      return paneler;
    }

  @RequestMapping(value = "/wait", method = RequestMethod.POST)
  @ResponseBody
  public String wait(HttpServletRequest request, HttpServletResponse response,
        @ModelAttribute User json) {
	  response.setHeader("Access-Control-Allow-Origin", "*");
	  response.setHeader("Access-Control-Allow-Methods", "GET, POST,PUT,DELETE,OPTIONS");
  //jsonログインページで入力したユーザーネームとパスワードが入っている
//      String username = json.getUsername();
//      String password = json.getPassword();
//      boolean valid = password.equals(userService.getUserPassword(username));//パスの確認
      return "待機";
    }
}
