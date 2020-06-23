package jp.co.plan_b.training.model.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.plan_b.training.model.dto.QuizStatus;
import jp.co.plan_b.training.model.repository.user.QuizStatusRepository;

@Service
public class QuizStatusServiceImp implements QuizStatusService {

	@Autowired
	QuizStatusRepository quizStatusRepository;

	@Override
	public String getQuizStatus(int qid) {
		System.out.println(qid);
		String status = quizStatusRepository.getQuizStatus(qid);
		System.out.println("status:"+status);
		return status;
	}
	@Override
	public void changeStatus(QuizStatus json) {
		quizStatusRepository.changeStatus(json.getQid(),json.getStatus());
	}
}
