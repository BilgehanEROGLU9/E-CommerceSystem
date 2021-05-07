package loginSystem2;

import loginSystem2.business.abstracts.ConfirmationService;
import loginSystem2.business.abstracts.UserService;
import loginSystem2.business.concretes.ConfirmationManager;
import loginSystem2.business.concretes.EmailManager;
import loginSystem2.business.concretes.UserManager;
import loginSystem2.business.concretes.ValidationManager;
import loginSystem2.dataAccess.concretes.HibernateUserDao;


public class Main {
//Bilgehan Ero�lu
	public static void main(String[] args) {
		UserService userService = new UserManager(new HibernateUserDao());
		ConfirmationService confirmationService = new ConfirmationManager(new ValidationManager(), new EmailManager(),userService);
		System.out.println("---------------------�YEL�K-------------------");
		confirmationService.signUp(1,"bilge@gmail.com","Bilgehan","Ero�lu","123456");
		confirmationService.signUp(2,"mahmut@gmail.com","Mahmut","Tuncer","987654");
		confirmationService.signUp(3, "sibel@outlook.com", "Sibel", "�elik", "159357");
		confirmationService.signUp(4, "sibel@outlook.com", "Sibel", "Y�ld�r�m", "13579454");//Ayn� eposta ile kay�r olmaya �al��mak
		confirmationService.signUp(5, "epostaDe�il", "P�nar", "KKKK", "44556677");//Varolmayan bir eposta ile kay�r olmaya �al��mak
		confirmationService.signUp(5, "fsdaf@hotmail.com", "P", "KKKK", "44556677");//Eksik isimle kay�t olmaya �al��mak
		confirmationService.signUp(7, "bilgenur@gmail.com", "bilgenur", "kaya", "123");//Eksik �ifre ile kay�r olmaya �al��mak
		

		
		System.out.println("---------------------T�M �YELER-------------------");
		userService.getAll();
		System.out.println("---------------------Gi�R��-------------------");
		confirmationService.logIn("bilge@", "");//�ifresiz girmeye �al��mak
		confirmationService.logIn("bilge@gmail.com", "123");//yanl�� �ifre ile giri� yaomaya �al��mak
		confirmationService.logIn("bilge@gmail.co", "123456");//yanl�� e�osta ile giri� yapmaya �al��mak
		confirmationService.logIn("bilge@gmail.com", "123456");//do�ru giri�
		
		
		
		


		
		

		


	}

}
