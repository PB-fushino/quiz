package jp.co.plan_b.training.application.service.quiz;

import java.util.List;

import jp.co.plan_b.training.model.dto.Answer;
import jp.co.plan_b.training.model.dto.Quiz;

public interface QuizService {

	/**
	 * すべてのユーザー情報を返します.
	 *   ユーザー情報がない場合は空配列を返します.
	 * @return すべてのユーザー情報
	 */
	List<Quiz> getAllQuiz();

	void answer(Answer json);

	List<Answer> checkTime(int i);

	String checkAnswer(Answer json);

	Quiz launchQuiz();

	Quiz getQuiz(int qid);

	Quiz checkQuiz();

	List<Answer> getScore(Integer id);

	List<Answer> getUserScore(Integer id);

	List<Answer> getScoreByQid(Integer qid, int i);

}
