package jp.co.plan_b.training.application.service.quiz;

import jp.co.plan_b.training.presentation.request.quiz.UpdateQuizStatusRequest;

public interface QuizStatusService {

  String getQuizStatus(int qid);

  void changeStatus(UpdateQuizStatusRequest requestParam);

}
