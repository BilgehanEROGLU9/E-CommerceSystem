package loginSystem2;

import loginSystem2.business.abstracts.ConfirmationService;
import loginSystem2.business.abstracts.UserService;
import loginSystem2.business.concretes.ConfirmationManager;
import loginSystem2.business.concretes.EmailManager;
import loginSystem2.business.concretes.UserManager;
import loginSystem2.business.concretes.ValidationManager;
import loginSystem2.dataAccess.concretes.HibernateUserDao;


public class Main {
//Bilgehan Eroðlu
	public static void main(String[] args) {
		UserService userService = new UserManager(new HibernateUserDao());
		ConfirmationService confirmationService = new ConfirmationManager(new ValidationManager(), new EmailManager(),userService);
		System.out.println("---------------------ÜYELÝK-------------------");
		confirmationService.signUp(1,"bilge@gmail.com","Bilgehan","Eroðlu","123456");
		confirmationService.signUp(2,"mahmut@gmail.com","Mahmut","Tuncer","987654");
		confirmationService.signUp(3, "sibel@outlook.com", "Sibel", "Çelik", "159357");
		confirmationService.signUp(4, "sibel@outlook.com", "Sibel", "Yýldýrým", "13579454");//Ayný eposta ile kayýr olmaya çalýþmak
		confirmationService.signUp(5, "epostaDeðil", "Pýnar", "KKKK", "44556677");//Varolmayan bir eposta ile kayýr olmaya çalýþmak
		confirmationService.signUp(5, "fsdaf@hotmail.com", "P", "KKKK", "44556677");//Eksik isimle kayýt olmaya çalýþmak
		confirmationService.signUp(7, "bilgenur@gmail.com", "bilgenur", "kaya", "123");//Eksik þifre ile kayýr olmaya çalýþmak
		

		
		System.out.println("---------------------TÜM ÜYELER-------------------");
		userService.getAll();
		System.out.println("---------------------GiÝRÝÞ-------------------");
		confirmationService.logIn("bilge@", "");//þifresiz girmeye çalýþmak
		confirmationService.logIn("bilge@gmail.com", "123");//yanlýþ þifre ile giriþ yaomaya çalýþmak
		confirmationService.logIn("bilge@gmail.co", "123456");//yanlýþ eðosta ile giriþ yapmaya çalýþmak
		confirmationService.logIn("bilge@gmail.com", "123456");//doðru giriþ
		
		
		
		


		
		

		


	}

}
