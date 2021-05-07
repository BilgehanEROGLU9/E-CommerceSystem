package loginSystem2.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import loginSystem2.business.abstracts.ValidationService;
import loginSystem2.entities.concretes.User;

public class ValidationManager implements ValidationService{

	@Override
	public boolean validEmail(User user) {
		
		String regex = "^(.+)@(.+)$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(user.getEmail());
		if (user.getEmail()==null||matcher.matches() == false) {
			System.out.println("Girdiðiniz email bilgisi yanlýþ");
			return false;
		}
		return true;
	
	}

	@Override
	public boolean validFirstName(User user) {
		if (user.getFirstName()==null||user.getFirstName().length()<2) {
			System.out.println("Girdiðiniz Ýsim bilgisi yanlýþ");
			return false;
		}
		return true;
	}

	@Override
	public boolean validLastName(User user) {
		if (user.getLastName()==null||user.getLastName().length()<2) {
			System.out.println("Girdiðiniz Soyadý bilgisi yanlýþ");
			return false;
		}
		return true;

		
	}

	@Override
	public boolean validPassword(User user) {
		if (user.getPassword()==null||user.getPassword().length()<6) {
			System.out.println("Girdiðiniz þifre bilgisi yanlýþ");
			return false;
		}
		return true;
	}

}
