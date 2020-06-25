package jp.co.plan_b.training.application.service.quiz;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jp.co.plan_b.training.infrastructure.entity.Answer;
import jp.co.plan_b.training.infrastructure.entity.Quiz;
import jp.co.plan_b.training.infrastructure.repository.quiz.QuizRepository;
import jp.co.plan_b.training.infrastructure.repository.user.UserRepository;
import jp.co.plan_b.training.presentation.request.quiz.GetQuizRequest;
import jp.co.plan_b.training.presentation.request.quiz.PostAnswerRequest;

@Service
public class QuizServiceImp implements QuizService {

  @Autowired
  QuizRepository quizRepository;
  @Autowired
  UserRepository userRepository;

  @Override
  public List<Quiz> getAllQuiz() {
    return quizRepository.getAllQuiz();
  }

  @Override
  public void answer(PostAnswerRequest answer) {
    int uid = answer.getUid();
    String username = userRepository.getUserById(uid).getName();
    quizRepository.insertAnswer(answer.getUid(), username, answer.getQid(), answer.getAnswer(),
        answer.getTime());
  }

  @Override
  public List<Answer> checkTime(int i) {
    return quizRepository.checkTime(i);
  }

  @Override
  public Boolean checkAnswer(PostAnswerRequest request) {
    Quiz quiz = quizRepository.getQuiz(request.getQid());
    return request.getAnswer().equals(quiz.getAnswer());
  }

  @Override
  public Quiz launchQuiz() {
    // TODO 自動生成されたメソッド・スタブ
    return quizRepository.launchQuiz();
  }

  @Override
  public Quiz getQuiz(int qid) {
    return quizRepository.getQuiz(qid);
  }

  @Override
  public Quiz checkQuiz() {
    // TODO 自動生成されたメソッド・スタブ
    return quizRepository.checkQuiz();
  }

  @Override
  public List<Answer> getScore(Integer id) {
    // TODO 自動生成されたメソッド・スタブ
    return quizRepository.getScore(id);
  }

  @Override
  public List<Answer> getUserScore(Integer id) {
    // TODO 自動生成されたメソッド・スタブ
    return quizRepository.getUserScore(id);
  }

  @Override
  public List<Answer> getScoreByQid(Integer qid, int i) {
    // TODO 自動生成されたメソッド・スタブ
    return quizRepository.getScoreByQid(qid, i);
  }

  @Override
  public Quiz searchQuiz(GetQuizRequest requestParam) {
    return quizRepository.searchQuiz(requestParam.getStatus());
  }


}
