package jp.co.plan_b.training.infrastructure.repository.user;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import jp.co.plan_b.training.infrastructure.entity.User;

@Mapper
@Repository
public interface UserRepository {

  /**
   * すべてのユーザー情報を取得します.
   *
   * @return すべてのユーザー情報
   */
  List<User> getAll();

  User getUserByName(String name);

  User getUserById(Integer id);

  void registerUser(String name);


}
