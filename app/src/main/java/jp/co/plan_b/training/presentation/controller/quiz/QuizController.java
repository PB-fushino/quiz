package jp.co.plan_b.training.presentation.controller.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import jp.co.plan_b.training.application.service.quiz.QuizService;
import jp.co.plan_b.training.application.service.quiz.QuizStatusService;
import jp.co.plan_b.training.application.service.user.UserService;
import jp.co.plan_b.training.infrastructure.entity.Answer;
import jp.co.plan_b.training.infrastructure.entity.Quiz;
import jp.co.plan_b.training.infrastructure.entity.Quizzes;
import jp.co.plan_b.training.infrastructure.entity.User;
import jp.co.plan_b.training.model.dto.AnswerMap;
import jp.co.plan_b.training.model.dto.AnswerNumber;
import jp.co.plan_b.training.model.dto.Corrects;
import jp.co.plan_b.training.presentation.request.quiz.GetQuizRequest;
import jp.co.plan_b.training.presentation.request.quiz.PostAnswerRequest;
import jp.co.plan_b.training.presentation.request.quiz.UpdateQuizStatusRequest;
import jp.co.plan_b.training.presentation.response.ResponseHeader;

@RestController
@CrossOrigin
public class QuizController {

  @Autowired
  UserService userService;

  @Autowired
  QuizService quizService;

  @Autowired
  QuizStatusService quizStatusService;

  @Autowired
  ResponseHeader responseHeader;

  /*
   * クイズ一覧を返す
   */
  @GetMapping("/quiz")
  public ResponseEntity<?> getQuiz(HttpServletRequest request, HttpServletResponse response)
      throws JsonProcessingException {
    List<Quiz> quizList = quizService.getAllQuiz();
    return ResponseEntity.ok().headers(responseHeader.getStandardGetHeader())
        .body(new Quizzes(quizList));
  }

  /*
   * 指定されたステータスのクイズを返す
   */
  @GetMapping("/quiz/status")
  public ResponseEntity<?> getQuizStatus(HttpServletRequest request, HttpServletResponse response,
      @Valid GetQuizRequest requestParam) throws JsonProcessingException {
    Quiz quiz = quizService.searchQuiz(requestParam);
    return ResponseEntity.ok().headers(responseHeader.getStandardGetHeader()).body(quiz);
  }

  /*
   * クイズのステータスを更新する
   */
  @PutMapping("/quiz/status")
  public ResponseEntity<?> changeQuizStatus(HttpServletRequest request,
      HttpServletResponse response, @RequestBody @Valid UpdateQuizStatusRequest requestParam,
      BindingResult binfingResult) {
    quizStatusService.changeStatus(requestParam);
    String status = quizStatusService.getQuizStatus(requestParam.getQid());
    return ResponseEntity.ok().headers(responseHeader.getStandardPutHeader()).body(status);
  }

  /*
   * 現時点での正解数降順と回答時間昇順でユーザー一覧を返す
   */
  @GetMapping("/ranking")
  public ResponseEntity<?> getRanking(HttpServletRequest request, HttpServletResponse response) {

    // TODO サービスに切り出し
    List<Corrects> corrects = new ArrayList<Corrects>();
    List<User> users = userService.getAllUser();
    // 以下ユーザーごとに正解数と回答時間を計算
    for (int i = 0; i < users.size(); i++) {
      List<Answer> scores = quizService.getScore(users.get(i).getId());// 正解のリスト
      List<Answer> userscores = quizService.getUserScore(users.get(i).getId());// ユーザーごとの時間と回答データ
      Integer numberOfCorrects = scores.size();
      Integer totalTime = 0;
      for (Answer userscore : userscores) {
        totalTime += userscore.getTime();
      }
      Corrects correct = new Corrects();
      correct.setUsername(users.get(i).getName());
      correct.setCorrects(numberOfCorrects);
      correct.setTimes(totalTime);
      corrects.add(correct);
    }

    // 回答時間が短い順にユーザーリストをソートする
    Comparator<Corrects> comparator =
        Comparator.comparing(Corrects::getCorrects).reversed().thenComparing(Corrects::getTimes);

    List<Corrects> sortedCorrectList =
        corrects.stream().sorted(comparator).collect(Collectors.toList());

    return ResponseEntity.ok().headers(responseHeader.getStandardGetHeader())
        .body(sortedCorrectList);
  }

  /*
   * 回答を登録し、正解不正解をbooleanで返す
   */
  @PostMapping("/answer")
  public ResponseEntity<?> answer(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute PostAnswerRequest requestParam) {
    quizService.answer(requestParam);
    return ResponseEntity.ok().headers(responseHeader.getStandardPostHeader())
        .body(quizService.checkAnswer(requestParam));
  }

  /*
   * 正解者と回答時間を返す 回答時間の短い順に返す
   */
  @GetMapping("/answer/{quizId}")
  public ResponseEntity<?> answerTime(HttpServletRequest request, HttpServletResponse response,
      @PathVariable("quizId") Integer quizId) {
    List<Answer> answer = quizService.checkTime(quizId);
    return ResponseEntity.ok().headers(responseHeader.getStandardGetHeader()).body(answer);
  }

  /*
   * 指定されたクイズIDに紐づく問題について、どの選択肢に何人回答したのかを返す
   */
  @GetMapping("/answer")
  public ResponseEntity<?> answercheck(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute Answer answer) {
    // 以下ユーザーごとに正解数と回答時間を計算
    // TODO サービス切り出し
    List<Answer> A = quizService.getScoreByQid(answer.getQid(), 0);
    List<Answer> B = quizService.getScoreByQid(answer.getQid(), 1);
    List<Answer> C = quizService.getScoreByQid(answer.getQid(), 2);
    List<Answer> D = quizService.getScoreByQid(answer.getQid(), 3);

    AnswerNumber number0 = new AnswerNumber(0, A.size());
    AnswerNumber number1 = new AnswerNumber(1, B.size());
    AnswerNumber number2 = new AnswerNumber(2, C.size());
    AnswerNumber number3 = new AnswerNumber(3, D.size());

    List<AnswerNumber> answerNumbers = Arrays.asList(number0, number1, number2, number3);
    AnswerMap map = new AnswerMap(answerNumbers);

    return ResponseEntity.ok().headers(responseHeader.getStandardGetHeader()).body(map);
  }

}
