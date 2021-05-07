package loginSystem2.core;

import loginSystem2.google.GoogleManager;

public class GoogleManagerAdapter implements GoogleService{

	@Override
	public void signUp(int id, String email, String firstName, String lastName, String password) {
		GoogleManager manager= new GoogleManager();
		manager.signUp(email,password);
		
	}

	@Override
	public void logIn(String email, String password) {
		GoogleManager manager= new GoogleManager();
		manager.logIn(email,password);
		
	}

}
