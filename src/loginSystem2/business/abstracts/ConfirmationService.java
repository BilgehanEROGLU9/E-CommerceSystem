package loginSystem2.business.abstracts;



public interface ConfirmationService {
	void signUp(int id,String email,String firstName,String lastName,String password);
	void logIn(String email,String password);
}
