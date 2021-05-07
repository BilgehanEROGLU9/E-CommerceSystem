package loginSystem2.business.concretes;

import loginSystem2.business.abstracts.ConfirmationService;
import loginSystem2.business.abstracts.EmailService;
import loginSystem2.business.abstracts.UserService;
import loginSystem2.business.abstracts.ValidationService;
import loginSystem2.entities.concretes.User;

public class ConfirmationManager implements ConfirmationService {

	private UserService userService;
	private ValidationService validationService;
	private EmailService emailService;
	
	public ConfirmationManager(ValidationService validationService, EmailService emailService,UserService userService) {
		super();

		this.validationService = validationService;
		this.emailService = emailService;
		this.userService = userService;
	}



	@Override
	public void logIn(String email,String password) {
		User user = userService.getLoginInfos(email, password);
		if (!isLogInFill(email, password))
		{
			System.out.println("Lütfen E-Posta ve Şifrenizi yazınız.");
			return;			
		}
			
		if (user == null)
		{
			System.out.println("E-Posta veya Şifre yanlış");
			return;
		}
		
		
		else 
		{			
			System.out.println("Hoşgeldin " + user.getFirstName());
		} 
		
	}

	@Override
	public void signUp(int id,String email , String firstName, String lastName, String password) {
		User user = new User(id,email,firstName,lastName,password);
		if (validationService.validEmail(user)==true&&validationService.validFirstName(user)==true&&validationService.validLastName(user)==true&&validationService.validPassword(user)==true&&isEmailNotUsed(email)) {
			System.out.println("Sevgili "+user.getFirstName()+", Lütfen Belirttiğiniz eposta adresine gelen onaylama bağlantısına tıklayınız");
			this.userService.add(user);
			this.emailService.verifyEmail(user);
		
		}
		else if (!isEmailNotUsed(email)) {System.out.println("Bu E-Posta adresine sahip bir hesap zaten var.");}
	
}
	private boolean isEmailNotUsed(String email) {
		return userService.getByEmail(email) == null;
	}
	private boolean isLogInFill(String email,String password) {
		if(email.length() > 0 && password.length() > 0) {
			return true;
		}
		return false;
	}

}
