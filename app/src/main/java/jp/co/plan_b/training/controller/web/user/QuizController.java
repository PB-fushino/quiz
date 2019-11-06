package jp.co.plan_b.training.controller.web.user;

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

import com.fasterxml.jackson.core.JsonProcessingException;

import jp.co.plan_b.training.model.dto.Quiz;
import jp.co.plan_b.training.model.dto.QuizStatus;
import jp.co.plan_b.training.model.service.user.QuizService;
import jp.co.plan_b.training.model.service.user.QuizStatusService;
import jp.co.plan_b.training.model.service.user.UserService;

@RestController
@CrossOrigin
public class QuizController {

	@Autowired
	UserService userService;

	@Autowired
	QuizService quizService;

	@Autowired
	QuizStatusService quizStatusService;

	Logger logger = LoggerFactory.getLogger(QuizController.class);

  @RequestMapping(value = "/quiz", method = RequestMethod.GET)
  @ResponseBody
  public List<Quiz> quiz() throws JsonProcessingException {
//	  String json = null;
//	  ObjectMapper objectMapper = new ObjectMapper();
	 //String name = json.getName();
	  System.out.println("OK");
	  List<Quiz> quiz = quizService.getAllQuiz();
//	  json = objectMapper.writeValueAsString(quiz);
//	  System.out.println(quiz.get(0).getProblem());

      return quiz;
    }

  @RequestMapping(value = "/quiz_status", method = RequestMethod.POST)
  @ResponseBody
  public String check_quiz_status(HttpServletRequest request, HttpServletResponse response,
        @ModelAttribute QuizStatus json) {
	  System.out.println("OK");
	  String status = quizStatusService.getQuizStatus(json.getQid());
	  System.out.println(status);
//	  json = objectMapper.writeValueAsString(quiz);
//	  System.out.println(quiz.get(0).getProblem());

      return status;
    }		
  @RequestMapping(value = "/change_status", method = RequestMethod.POST)
  @ResponseBody
  public String change_status(HttpServletRequest request, HttpServletResponse response,
        @ModelAttribute QuizStatus json) {
	  System.out.println("OK");
	  quizStatusService.changeStatus(json);
	  System.out.println(json.getStatus());
//	  json = objectMapper.writeValueAsString(quiz);
//	  System.out.println(quiz.get(0).getProblem());
	  String status = quizStatusService.getQuizStatus(json.getQid());

      return status;
    }

}
