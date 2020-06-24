package jp.co.plan_b.training.application.service.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jp.co.plan_b.training.infrastructure.entity.QuizStatus;
import jp.co.plan_b.training.infrastructure.repository.quiz.QuizStatusRepository;

@Service
public class QuizStatusServiceImp implements QuizStatusService {

  @Autowired
  QuizStatusRepository quizStatusRepository;

  @Override
  public String getQuizStatus(int qid) {
    System.out.println(qid);
    String status = quizStatusRepository.getQuizStatus(qid);
    System.out.println("status:" + status);
    return status;
  }

  @Override
  public void changeStatus(QuizStatus json) {
    quizStatusRepository.changeStatus(json.getQid(), json.getStatus());
  }
}
