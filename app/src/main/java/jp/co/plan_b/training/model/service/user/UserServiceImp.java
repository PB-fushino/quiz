package jp.co.plan_b.training.model.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.plan_b.training.model.dto.User;
import jp.co.plan_b.training.model.repository.user.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUser() {
		return userRepository.getAll();
	}

}
