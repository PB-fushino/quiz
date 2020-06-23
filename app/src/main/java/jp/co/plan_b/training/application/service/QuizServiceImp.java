package jp.co.plan_b.training.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jp.co.plan_b.training.infractstucture.repository.quiz.QuizRepository;
import jp.co.plan_b.training.infractstucture.repository.user.UserRepository;
import jp.co.plan_b.training.model.dto.Answer;
import jp.co.plan_b.training.model.dto.Quiz;

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
	public void answer(Answer answer) {
		  int uid = answer.getUid();
		  String username = userRepository.getUserById(uid).getName();
		quizRepository.insertAnswer(
				answer.getUid(),
				username,
				answer.getQid(),
				answer.getAnswer(),
				answer.getTime()
				);
	}

	@Override
	public List<Answer> checkTime(int i) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(i);
		return quizRepository.checkTime(i);
	}

	@Override
	public String checkAnswer(Answer json) {
		int Answer = json.getAnswer();
		Quiz quiz = quizRepository.getQuiz(json.getQid());
		if (Answer == quiz.getAnswer()) {
			return "正解";
		}else {
			return "不正解";
		}

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
		return quizRepository.getScoreByQid(qid,i);
	}

}
