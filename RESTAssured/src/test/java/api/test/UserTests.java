package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	
	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setupData() {
		
		faker= new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setName(faker.name().name());
		userPayload.setJob(faker.job().title());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setAvater(faker.avatar().image());
		
	}
	
	@Test(priority=1)
	public void testPostUser() {
		
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 201);
	
	}
	
	@Test(priority=2)
	public void testGetUser() {
		
		Response response = UserEndPoints.readUser();
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	
	}
	
	@Test(priority=3)
	public void testUpdateUser() {
		
		userPayload.setName(faker.name().name());
		userPayload.setJob(faker.job().title());
		
		Response response = UserEndPoints.updateUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	
	}



}
