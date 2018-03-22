package models;

import utils.RandomValuesPicker;

public class UserModel {

	public String firstName;
	public String lastName;
	public String email;
	public String phone;
	
	public static UserModel getRandomLead() {
		UserModel user = new UserModel();

		user.firstName = RandomValuesPicker.getRandomFirstName();
		user.lastName = RandomValuesPicker.getRandomLastName();
		user.email = "test@email.com";
		user.phone = "1234567890";

		return user;
	}
}