package jp.co.plan_b.training.model.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.plan_b.training.model.dto.Quiz;
import jp.co.plan_b.training.model.repository.user.QuizRepository;

@Service
public class QuizServiceImp implements QuizService {

	@Autowired
	QuizRepository quizRepository;

	@Override
	public List<Quiz> getAllQuiz() {
		return quizRepository.getAllQuiz();
	}

}
