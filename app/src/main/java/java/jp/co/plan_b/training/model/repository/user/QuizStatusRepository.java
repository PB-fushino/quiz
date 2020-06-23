package jp.co.plan_b.training.model.repository.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QuizStatusRepository {

	/**
	 * すべてのユーザー情報を取得します.
	 * @param qid
	 * @return すべてのユーザー情報
	 */

	String getQuizStatus(int qid);

	void changeStatus(int qid, String status);

}
