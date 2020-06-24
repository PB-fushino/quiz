package jp.co.plan_b.training.application.service.quiz;

import jp.co.plan_b.training.infrastructure.entity.QuizStatus;

public interface QuizStatusService {

	/**
	 * すべてのユーザー情報を返します.
	 *   ユーザー情報がない場合は空配列を返します.
	 * @param qid
	 * @return すべてのユーザー情報
	 */
	String getQuizStatus(int qid);

	void changeStatus(QuizStatus json);

}
