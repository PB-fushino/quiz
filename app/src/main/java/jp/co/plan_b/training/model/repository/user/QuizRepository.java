package jp.co.plan_b.training.model.repository.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import jp.co.plan_b.training.model.dto.Quiz;

@Mapper
@Repository
public interface QuizRepository {

	/**
	 * すべてのユーザー情報を取得します.
	 * @return すべてのユーザー情報
	 */
	List<Quiz> getAllQuiz();

}
