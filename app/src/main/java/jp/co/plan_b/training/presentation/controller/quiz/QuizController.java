package jp.co.plan_b.training.presentation.controller.quiz;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import jp.co.plan_b.training.application.service.quiz.QuizService;
import jp.co.plan_b.training.application.service.quiz.QuizStatusService;
import jp.co.plan_b.training.application.service.user.UserService;
import jp.co.plan_b.training.model.dto.Answer;
import jp.co.plan_b.training.model.dto.Corrects;
import jp.co.plan_b.training.model.dto.Quiz;
import jp.co.plan_b.training.model.dto.QuizStatus;
import jp.co.plan_b.training.model.dto.User;

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

//全てのクイズを渡す
  @RequestMapping(value = "/quiz", method = RequestMethod.GET)
  @ResponseBody
  public List<Quiz> quiz(HttpServletRequest request, HttpServletResponse response,
	        @ModelAttribute User json) throws JsonProcessingException {

//	  response.setHeader("Access-Control-Allow-Origin", "http://happywedding-manae-shinji.tk");
//      response.setHeader("Access-Control-Allow-Credentials", "true");

	  response.setHeader("Access-Control-Allow-Origin", "*");
	  response.setHeader("Access-Control-Allow-Methods", "GET, POST,PUT,DELETE,OPTIONS");


//	  String json = null;
//	  ObjectMapper objectMapper = new ObjectMapper();
	 //String name = json.getName();
	  System.out.println("OK");
	  List<Quiz> quiz = quizService.getAllQuiz();
      return quiz;
    }
//出題になっているクイズのデータを返す
  @RequestMapping(value = "/launchquiz", method = RequestMethod.GET)
  @ResponseBody
  public Quiz launchQuiz(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
	  response.setHeader("Access-Control-Allow-Origin", "*");
	  response.setHeader("Access-Control-Allow-Methods", "GET, POST,PUT,DELETE,OPTIONS");
	 Quiz quiz = quizService.launchQuiz();
      return quiz;
    }
//回答チェックになっているクイズのデータを返す
  @RequestMapping(value = "/checkquiz", method = RequestMethod.GET)
  @ResponseBody
  public Quiz checkQuiz(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
	  response.setHeader("Access-Control-Allow-Origin", "*");
	  response.setHeader("Access-Control-Allow-Methods", "GET, POST,PUT,DELETE,OPTIONS");
	 Quiz quiz = quizService.checkQuiz();
      return quiz;
    }



  //最終的な、正解数と回答時間をランキングで渡す
  @RequestMapping(value = "/winner", method = RequestMethod.GET)
  @ResponseBody
  public Stream<Corrects> winner(HttpServletRequest request, HttpServletResponse response,
	        @ModelAttribute User json) {

	  response.setHeader("Access-Control-Allow-Origin", "*");
	  response.setHeader("Access-Control-Allow-Methods", "GET, POST,PUT,DELETE,OPTIONS");

	  List<Corrects> corrects = new ArrayList<Corrects>();
	  List<User> users = userService.getAllUser();
	  //以下ユーザーごとに正解数と回答時間を計算
	  for( int i = 0 ; i < users.size(); i ++ ) {
		  List<Answer> scores = quizService.getScore(users.get(i).getId());//正解してる物
		  List<Answer> userscores = quizService.getUserScore(users.get(i).getId());//ユーザーごとの時間と回答データ
		  Corrects correct = new Corrects();
		  correct.setUsername(users.get(i).getName());
		  Integer numberOfCorrects = 0;
		  Integer totalTime = 0;
//		  answer.answer = quiz.answer
//					and
			  if( CollectionUtils.isEmpty(scores)) {
				  System.out.println("karadayoo");
			  } else {
				  numberOfCorrects += scores.size();
				  for (Answer score:scores) {
					  System.out.println("名前:"+score.getUsername());
					  System.out.println("時間:"+score.getTime());
//					  totalTime += score.getTime();
					  System.out.println("正解数："+numberOfCorrects);
					  System.out.println("総回答時間："+totalTime);
				  }
		  }

			  if( CollectionUtils.isEmpty(userscores)) {
				  System.out.println("karadayoo");
			  } else {
				  for (Answer userscore:userscores) {
//					  System.out.println("名前:"+score.getUsername());
//					  System.out.println("時間:"+score.getTime());
					  totalTime += userscore.getTime();
//					  System.out.println("総回答時間："+totalTime);
				  }
		  }
		  correct.setCorrects(numberOfCorrects);
		  correct.setTimes(totalTime);
		  corrects.add(correct);
	  }
//	  Collections.sort(corrects, new CorrectComparator());
	  Comparator<Corrects> comparator =
			  Comparator.comparing(Corrects::getCorrects).reversed().thenComparing(Corrects::getTimes);
//			  Comparator.comparing(Corrects::getCorrects).thenComparing(Corrects::getTimes);

	  corrects.stream().sorted(comparator).forEach(a ->
	    System.out.println(a.getUsername() + " " + a.getTimes() + " " + a.getCorrects()));
      return corrects.stream().sorted(comparator);
    }
  public class CorrectComparator implements Comparator<Corrects> {

		@Override
		public int compare(Corrects p1, Corrects p2) {
			return p1.corrects < p2.corrects ? -1 : 1;
		}
	}


//出題になっているクイズがあるかどうかチェックしてあればtrueを返す
  //stanby画面
  @RequestMapping(value = "/quiz_status", method = RequestMethod.GET)
  @ResponseBody
  public Quiz check_quiz_status(HttpServletRequest request, HttpServletResponse response) {
	  response.setHeader("Access-Control-Allow-Origin", "*");
	  response.setHeader("Access-Control-Allow-Methods", "GET, POST,PUT,DELETE,OPTIONS");
	  Quiz quiz = quizService.launchQuiz();
	  if (quiz != null) {
		  return  quiz;
	  }else {
		  return null;
	  }
    }


//qidを受け取ってステータスを返す
  @RequestMapping(value = "/quiz_status_answer", method = RequestMethod.POST)
  @ResponseBody
  public String quiz_status_answer(HttpServletRequest request, HttpServletResponse response,
	        @ModelAttribute QuizStatus json) {
	  response.setHeader("Access-Control-Allow-Origin", "*");
	  response.setHeader("Access-Control-Allow-Methods", "GET, POST,PUT,DELETE,OPTIONS");
	  String status = quizStatusService.getQuizStatus(json.getQid());
	  return status;
    }
  //管理画面で問題のステータスをupdateしてstatusを返す
  @RequestMapping(value = "/change_status", method = RequestMethod.POST)
  @ResponseBody
  public String change_status(HttpServletRequest request, HttpServletResponse response,
        @ModelAttribute QuizStatus json) {

	  response.setHeader("Access-Control-Allow-Origin", "*");
	  response.setHeader("Access-Control-Allow-Methods", "GET, POST,PUT,DELETE,OPTIONS");
	  quizStatusService.changeStatus(json);
	  System.out.println(json.getStatus());
	  String status = quizStatusService.getQuizStatus(json.getQid());
      return status;
    }


//healthcheck
  @RequestMapping(value = "/health", method = RequestMethod.GET)
  @ResponseBody
  public String quiz(HttpServletRequest request, HttpServletResponse response) {
    return "OK";
  }


//パネラーが回答した際に、回答情報を返す
  @RequestMapping(value = "/answer", method = RequestMethod.POST)
  @ResponseBody
  public String answer(HttpServletRequest request, HttpServletResponse response,
        @ModelAttribute Answer json) {

	  response.setHeader("Access-Control-Allow-Origin", "*");
	  response.setHeader("Access-Control-Allow-Methods", "GET, POST,PUT,DELETE,OPTIONS");

	  System.out.println("問題"+json.getQid());
	  quizService.answer(json);
	  System.out.println("answer"+json.getAnswer());
      return quizService.checkAnswer(json);
    }

  //回答じかんと正解者を返して、問題ごとの優勝者を発表する
  @RequestMapping(value = "/checkTime", method = RequestMethod.POST)
  @ResponseBody
  public List<Answer> checkTime(HttpServletRequest request, HttpServletResponse response,
        @ModelAttribute Answer id) {
	  HttpSession session = request.getSession(true);//

	  response.setHeader("Access-Control-Allow-Origin", "*");
	  response.setHeader("Access-Control-Allow-Methods", "GET, POST,PUT,DELETE,OPTIONS");
	  List<Answer> answer = quizService.checkTime(id.getQid());
      return answer;
    }

//qidを渡して問題ごとの回答者数をわたす。
  @RequestMapping(value = "/checkanswer", method = RequestMethod.POST)
  @ResponseBody
  public  HashMap<Integer,Integer> answercheck(HttpServletRequest request, HttpServletResponse response,
	        @ModelAttribute Answer answer) {
	  response.setHeader("Access-Control-Allow-Origin", "*");
	  response.setHeader("Access-Control-Allow-Methods", "GET, POST,PUT,DELETE,OPTIONS");
	  //以下ユーザーごとに正解数と回答時間を計算
		  List<Answer> A = quizService.getScoreByQid(answer.getQid(),0);
		  List<Answer> B = quizService.getScoreByQid(answer.getQid(),1);
		  List<Answer> C = quizService.getScoreByQid(answer.getQid(),2);
		  List<Answer> D = quizService.getScoreByQid(answer.getQid(),3);
		  //qidからアンサーデータを取得
		  int sizeOfA = 0;
		  int sizeOfB = 0;
		  int sizeOfC = 0;
		  int sizeOfD = 0;

		  sizeOfA = A.size();
		  sizeOfB = B.size();
		  sizeOfC = C.size();
		  sizeOfD = D.size();

		  HashMap<Integer,Integer> map = new HashMap<>();
		  map.put(0, sizeOfA);
		  map.put(1, sizeOfB);
		  map.put(2, sizeOfC);
		  map.put(3, sizeOfD);

		  return map;
	  }



}


