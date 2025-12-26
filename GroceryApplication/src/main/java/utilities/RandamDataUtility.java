package utilities;

import com.github.javafaker.Faker;

public class RandamDataUtility {

	Faker fake = new Faker(); // object created for Faker class , it is predefined class
	
	public String randomUserName()
	{
		return fake.name().username(); // names are in name method
	}
	
	public String randomPassword()
	{
		return fake.internet().password(); //passwords are in internet method
	}
	
	public String randomFullName()
	{
		return fake.name().fullName();
	}
	
	public String randomEmail()
	{
		return fake.internet().emailAddress();
	}
}
