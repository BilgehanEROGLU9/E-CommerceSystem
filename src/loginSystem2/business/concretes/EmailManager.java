package loginSystem2.business.concretes;

import loginSystem2.business.abstracts.EmailService;
import loginSystem2.entities.concretes.User;

public class EmailManager implements EmailService {

	@Override
	public void verifyEmail(User user) {
		System.out.println("Hesab�n�z� aktifle�tirdiniz, Tebrikler "+user.getFirstName()+"!");
		
	}

}
