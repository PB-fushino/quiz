package jp.co.plan_b.training.controller.web.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.plan_b.training.model.dto.User;
import jp.co.plan_b.training.model.service.user.UserService;

@Controller
@RequestMapping("/users")
public class UserWebController {

	@Autowired
	UserService userService;

	@GetMapping
	public String index(Model model) {
		// すべてのユーザー情報を取得
		List<User> users = userService.getAllUser();

		model.addAttribute("users", users);
		return "user/index";
	}

}
