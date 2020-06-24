package jp.co.plan_b.training.infrastructure.repository.quiz;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import jp.co.plan_b.training.infrastructure.entity.Answer;
import jp.co.plan_b.training.infrastructure.entity.Quiz;

@Mapper
@Repository
public interface QuizRepository {

  /**
   * すべてのユーザー情報を取得します.
   *
   * @return すべてのユーザー情報
   */
  List<Quiz> getAllQuiz();

  void insertAnswer(Integer uid, String username, Integer qid, Integer answer, Integer time);

  List<Answer> checkTime(int i);

  Quiz getQuiz(Integer qid);

  Quiz launchQuiz();

  Quiz checkQuiz();

  List<Answer> getScore(Integer id);

  List<Answer> getUserScore(Integer id);

  List<Answer> getScoreByQid(Integer qid, int i);


}
