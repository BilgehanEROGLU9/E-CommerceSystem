package loginSystem2.business.abstracts;

import loginSystem2.entities.concretes.User;

public interface ValidationService {
	boolean validEmail(User user);
	boolean validFirstName(User user);
	boolean validLastName(User user);
	boolean validPassword(User user);

}
