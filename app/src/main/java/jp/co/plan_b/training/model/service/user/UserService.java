package jp.co.plan_b.training.model.service.user;

import java.util.List;

import jp.co.plan_b.training.model.dto.User;

public interface UserService {

	/**
	 * すべてのユーザー情報を返します.
	 *   ユーザー情報がない場合は空配列を返します.
	 * @return すべてのユーザー情報
	 */
	List<User> getAllUser();

	User getUserById(Integer id);

	User getUserByname(String name);

	void registerUser(String name);


}
