package jp.co.plan_b.training.application.service.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jp.co.plan_b.training.infrastructure.repository.quiz.QuizStatusRepository;
import jp.co.plan_b.training.presentation.request.quiz.UpdateQuizStatusRequest;

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
  public void changeStatus(UpdateQuizStatusRequest requestParam) {
    quizStatusRepository.changeStatus(requestParam.getQid(), requestParam.getStatus());
  }

}
