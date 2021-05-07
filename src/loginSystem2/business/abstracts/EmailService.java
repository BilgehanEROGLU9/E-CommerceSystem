package loginSystem2.business.abstracts;

import loginSystem2.entities.concretes.User;

public interface EmailService {
	void verifyEmail(User user);

}
