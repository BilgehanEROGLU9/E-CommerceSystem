package loginSystem2.dataAccess.abstracts;

import java.util.List;

import loginSystem2.entities.concretes.User;



public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(User user);
	User get(int id);
	User getByEmail(String email);
	User getLoginInfos(String email, String password);
	List<User> getall();

}
