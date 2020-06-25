package jp.co.plan_b.training.application.service.quiz;

import java.util.List;
import jp.co.plan_b.training.infrastructure.entity.Answer;
import jp.co.plan_b.training.infrastructure.entity.Quiz;
import jp.co.plan_b.training.presentation.request.quiz.GetQuizRequest;
import jp.co.plan_b.training.presentation.request.quiz.PostAnswerRequest;

public interface QuizService {

  /**
   * すべてのユーザー情報を返します. ユーザー情報がない場合は空配列を返します.
   *
   * @return すべてのユーザー情報
   */
  List<Quiz> getAllQuiz();

  void answer(PostAnswerRequest requestParam);

  List<Answer> checkTime(int i);

  Boolean checkAnswer(PostAnswerRequest requestParam);

  Quiz launchQuiz();

  Quiz getQuiz(int qid);

  Quiz checkQuiz();

  List<Answer> getScore(Integer id);

  List<Answer> getUserScore(Integer id);

  List<Answer> getScoreByQid(Integer qid, int i);

  Quiz searchQuiz(GetQuizRequest requestParam);

}
