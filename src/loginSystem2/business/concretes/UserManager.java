package loginSystem2.business.concretes;


import java.util.List;

import loginSystem2.business.abstracts.UserService;
import loginSystem2.dataAccess.abstracts.UserDao;
import loginSystem2.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Override
	public User getByEmail(String email) {
		
		return userDao.getByEmail(email);
	}

	@Override
	public User getLoginInfos(String email, String password) {
		return userDao.getLoginInfos(email, password);
	}

	@Override
	public List<User> getAll() {
		return userDao.getall();
	}

	@Override
	public void add(User user) {
		userDao.add(user);
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

}
