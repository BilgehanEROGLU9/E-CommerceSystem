package loginSystem2.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import loginSystem2.dataAccess.abstracts.UserDao;
import loginSystem2.entities.concretes.User;

public class HibernateUserDao implements UserDao{

	List<User> users = new ArrayList<User>();
	@Override
	public void add(User user) {
		System.out.println("Hibernate ile gönderildi : "+user.getEmail());
		users.add(user);
		
	}

	@Override
	public void update(User user) {
		
		
	}

	@Override
	public void delete(User user) {
		users.removeIf(usr -> usr.getId() == user.getId());
		
	}

	@Override
	public User get(int id) {
		for(User user : users) {
			if (user.getId() == id)
			{
					return user;
			}
		}
	

		return null;
	}

	@Override
	public List<User> getall() {
		System.out.println("Tüm kayýtlý kullanýcýlar :");

		for (User user : users) {
			System.out.println("Id: " + user.getId() + "\nAd-Soyad: " + user.getFirstName() + " " + user.getLastName() + "\nE-Posta: " + user.getEmail());
		}
		return null;
	}

	@Override
	public User getByEmail(String email) {
		for(User user : users) {
			if (user.getEmail() == email) {
				return user;
			}
			
		}
		return null;
	}

	@Override
	public User getLoginInfos(String email, String password) {
		for(User user : users) {
			if (user.getPassword() == password && user.getEmail() == email) {
				return user;
			}
		}
		return null;
	}

}
